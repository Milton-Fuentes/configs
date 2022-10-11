package com.atser.tools.atserutil.file;

import com.atser.tools.atserutil.image.ImageSupport;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import org.apache.tika.Tika;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.ws.rs.core.MultivaluedMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * Created by dropal.
 */
public class FileSupport {

    public static Boolean removeFile(File file) throws IOException {
        try {
            return Files.deleteIfExists(file.toPath());
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found..!!");
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred..!!");
        }
        return Boolean.FALSE;
    }

    public static Boolean removeFile(String path) throws IOException {
        try {
            return Files.deleteIfExists(new File(path).toPath());
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found..!!");
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred..!!");
        }
        return Boolean.FALSE;
    }

    public static void CopyAndReplaceFile(File orig, File dest) throws IOException {
        Files.deleteIfExists(dest.toPath());
        Files.copy(orig.toPath(), dest.toPath());
    }

    public static void CopyFile(File orig, File dest) throws IOException {
        Files.copy(orig.toPath(), dest.toPath());
    }

    public static void MoveFile(String orig, String dest) throws IOException {
        MoveFile(new File(orig), new File(dest));
    }

    public static void MoveFile(File orig, File dest) throws IOException {
        if (orig.exists()) {
            Files.move(orig.toPath(), dest.toPath(), REPLACE_EXISTING);
        }
    }

    /**
     * Clean All Files in Directory
     *
     * @param directory
     * @throws IOException
     */
    public static void cleanDirectory(File directory) throws IOException {
        if (directory.isDirectory() && directory.exists()) {
            FileUtils.cleanDirectory(directory);
        }
    }

    /**
     * Sanitize File Name
     *
     * @param filename
     * @return
     */
    public static String sanitizeFileName(String filename) {
        return StringSupport.replaceString(filename, "[\\\\+,\\/+]", "-");
    }

    /**
     * Convert File To ByteArrayInputStream
     *
     * @param path
     * @return ByteArrayInputStream
     */
    public static ByteArrayInputStream FicheroAByteArrayIS(String path) {
        ByteArrayInputStream byteArray = null;
        try {
            byteArray = new ByteArrayInputStream(FileToByte(new File(path)));
            return byteArray;
        } catch (IOException ex) {
            return null;
        } finally {
            try {
                byteArray.close();
            } catch (IOException ex) {
            }
        }
    }

    /**
     * Extract filename from HTTP heaeders.
     *
     * @param headers
     * @return
     */
    public static String getFileNameMultiParts(MultivaluedMap<String, String> headers) {
        String[] contentDisposition = headers.getFirst("Content-Disposition").split(";");
        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = sanitizeString(name[1]);
                return finalFileName;
            }
        }
        return "unknown";
    }

    private static String sanitizeString(String s) {
        return s.trim().replaceAll("\"", "");
    }

    public static Map<String, Object> writeFile(byte[] content, Map<String, Object> files) throws IOException {
        return writeFile(content, files, false);
    }

    public static Map<String, Object> writeFileWithBuffer(byte[] content, Map<String, Object> files) throws IOException {
        return writeFile(content, files, true);
    }

    public static Map<String, Object> writeFile(byte[] content, Map<String, Object> files, Boolean withBuffer) throws IOException {
        Map<String, Object> filesRs = files;
        File filearea = new File(StringSupport.emptyOnNull(files.get("filearea")));
        if (files.containsKey("createfolders")) {
            if (!filearea.exists()) {
                filearea.mkdirs();
            }
        }
        File file = new File(StringSupport.emptyOnNull(files.get("filename")));
        if (!file.exists()) {
            file.createNewFile();
        }

        if (withBuffer) {
            try ( BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
                bos.write(content, 0, content.length);
                bos.flush();
                bos.close();
            }
        } else {
            try ( FileOutputStream fop = new FileOutputStream(file)) {
                fop.write(content);
                fop.flush();
                fop.close();
            }
        }

        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filesRs.put("size", String.valueOf(attr.size()));
        filesRs.put("mimetype", getFileTypeMime(file));
        return filesRs;
    }

    public static Map<String, Object> moveFileAndGetMetaData(String orig, String dest) throws IOException {
        Map<String, Object> files = new HashMap<>();
        String ofilename = getFileName(dest);
        String filePath = getFolderPathFromFile(dest);
        files.put("ext", FilenameUtils.getExtension(dest));
        files.put("timename", StringSupport.generateUUID());
        String filename = filePath + files.get("timename") + "." + files.get("ext");
        files.put("filearea", filePath);
        files.put("ofilename", ofilename);
        files.put("filename", filename);
        FileSupport.MoveFile(orig, filename);
        File finalFile = new File(filename);
        BasicFileAttributes attr = Files.readAttributes(finalFile.toPath(), BasicFileAttributes.class);
        files.put("size", String.valueOf(attr.size()));
        files.put("mimetype", getFileTypeMime(finalFile));
        return files;
    }

    public static Map<String, Object> getMetaDataServerFilename(String filename, String path) throws IOException {
        Map<String, Object> files = new HashMap<>();
        files.put("filearea", path);
        files.put("ofilename", filename);
        files.put("ext", FilenameUtils.getExtension(path + filename));
        files.put("timename", StringSupport.generateUUID());
        files.put("filename", path + files.get("timename") + "." + files.get("ext"));
        return files;
    }

    public static Map<String, Object> getFileMetaData(String filePath, Map<String, Object> baseMeta) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IOException("Empty file Path");
        }
        Map<String, Object> filesRs;
        if (baseMeta == null) {
            filesRs = new HashMap<>();
        } else {
            filesRs = baseMeta;
        }
        File file = new File(filePath);
        if (file.exists()) {
            BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            filesRs.put("size", String.valueOf(attr.size()));
            filesRs.put("mimetype", getFileTypeMime(file));
        }
        return filesRs;
    }

    public static Map<String, Object> getFileMetaData(String filePath) throws IOException {
        return getFileMetaData(filePath, null);
    }

    public static Map<String, Object> getUploadFileMetaData(String filename, String uploadFolderPath, Map<String, Object> params) throws IOException {
        Map<String, Object> files = new HashMap<>();
        String path = uploadFolderPath;
        if (uploadFolderPath.charAt(uploadFolderPath.length() - 1) != File.separatorChar) {
            path += File.separatorChar;
        }
        if (params != null) {
            if (params.containsKey("clientId") && StringSupport.isNotNullAndNotEmpty(params.get("clientId"))) {
                path += params.get("clientId") + "/";
                if (params.containsKey("projectId") && params.containsKey("contractId") && StringSupport.isNotNullAndNotEmpty(params.get("projectId")) && StringSupport.isNotNullAndNotEmpty(params.get("contractId"))) {
                    path += params.get("projectId") + "/" + params.get("contractId") + "/";
                } else {
                    path += "general/";
                }
                files.put("filearea", path);
                files.put("ofilename", filename);
                files.put("ext", FilenameUtils.getExtension(path + filename));
                files.put("timename", StringSupport.generateUUID());
                files.put("filename", path + files.get("timename") + "." + files.get("ext"));
                files.put("createfolders", "true");
                return files;
            }
        }
        files.put("filearea", path);
        files.put("filename", path + filename);
        return files;
    }

    public static Map<String, Object> scaleFileImage(byte[] file, Map<String, Object> fileInfo, Map<String, Object> params) {
        Map<String, Object> imageInfo = new HashMap<>();
        if (params != null && params.containsKey("scalate") && StringSupport.getBoolean(params.get("scalate"))) {
            try {
                if (fileInfo.containsKey("mimetype") && fileInfo.get("mimetype").toString().contains("image")) {
                    BufferedImage image = ImageSupport.convertByteArrayToBufferedImage(file);
                    BufferedImage imageResult = ImageSupport.scalate(image, 750, 550);
                    String name = fileInfo.get("filearea").toString() + fileInfo.get("timename") + "_scalated." + fileInfo.get("ext");
                    File outputfile = new File(name);
                    ImageIO.write(imageResult, "png", outputfile);
                    imageInfo.put("width", imageResult.getWidth());
                    imageInfo.put("height", imageResult.getHeight());
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(FileSupport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return imageInfo;
    }

    /**
     * Busqueda recursiva de ficheros El metodo hace una busqueda recursiva de
     * todos los ficheros y/o subdirectorios que puedan existir en un directorio
     * dado.
     *
     * @param file: Directorio donde se realizara la busqueda de ficheros.
     * @return
     * @return: Listado de ficheros encontrados
     */
    public static List<File> getDirectoryFileList(File file) {
        // Listado de ficheros a devolver
        List<File> fileList = new ArrayList<>();
        // Preguntando si es directorio
        if (file.isDirectory()) {
            // Si es directorio se piden todos sus archivos internos (directorios y ficheros)
            File[] subFileList = file.listFiles();
            // Se llama recursivamente a este metodo para todos los archivos internos
            for (File subFileList1 : subFileList) {
                // El resultado de cada llamada se adiciona a la lista de ficheros a devolver
                fileList.addAll(getDirectoryFileList(subFileList1));
            }
        } else {
            // Si es fichero se adiciona a la lista de ficheros a devolver
            fileList.add(file);
        }
        return fileList;
    }

    public static Map<String, File> getMapFilesInFolder(File folder) {
        Map<String, File> map = new LinkedHashMap<>();
        if (folder.isDirectory()) {
            File[] subFileList = folder.listFiles();
            for (File file : subFileList) {
                map.put(FilenameUtils.removeExtension(file.getName()), file);
            }
        }
        return map;
    }

    /**
     * Busqueda recursiva de ficheros El metodo hace una busqueda recursiva de
     * todos los ficheros y/o subdirectorios que puedan existir en un listado de
     * directorios.
     *
     * @param files: Listado de directorios y/o ficheros donde se realizaran las
     * busquedas de ficheros.
     * @return
     * @return: Listado de ficheros encontrados
     */
    public static List<File> getDirectoriesFileList(File[] files) {
        List<File> resultFileList = new ArrayList<>();
        for (File file : files) {
            resultFileList.addAll(getDirectoryFileList(file));
        }
        return resultFileList;
    }

    public static byte[] getXMLFromFile(String xmlFile) {
        StringBuilder xml = null;
        String tmp = null;
        try {
            xml = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(xmlFile));

            while ((tmp = reader.readLine()) != null) {
                xml.append(tmp);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return xml.toString().getBytes();
    }

    public void ExtraerFicheroDentroJar(String direccionOrg, String direccionDest) throws java.lang.Exception {
        try {
            getClass().getResource(direccionOrg);
            InputStream in = getClass().getResourceAsStream(direccionOrg);
            OutputStream out = new FileOutputStream(direccionDest);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] FileToByte(File file) throws IOException {

        byte[] buffer = new byte[(int) file.length()];
        InputStream ios = null;
        try {
            ios = new FileInputStream(file);
            if (ios.read(buffer) == -1) {
                throw new IOException("EOF reached while trying to read the whole file");
            }
        } finally {
            try {
                if (ios != null) {
                    ios.close();
                }
            } catch (IOException e) {
            }
        }
        return buffer;
    }

    public static String getFileTypeMime(String url) {
        try {
            File f = new File(url);
            Tika defaulttika = new Tika();
            return defaulttika.detect(f);
        } catch (Exception e) {
            return "-1";
        }
    }

    public static String getFileTypeMime(File url) {
        try {
            Tika defaulttika = new Tika();
            return defaulttika.detect(url);
        } catch (Exception e) {
            return "-1";
        }
    }

    public static String getFileTypeMime(InputStream url) {
        try {
            Tika defaulttika = new Tika();
            return defaulttika.detect(url);
        } catch (Exception e) {
            return "-1";
        }
    }

    public static String getFileName(String fileDc) {
        File fd = new File(fileDc);
        return getFileName(fd);
    }

    public static String getFileName(File fileDc) {
        if (fileDc != null) {
            return FilenameUtils.getName(fileDc.getAbsolutePath());
        }
        return "";
    }

    public static String getFolderPathFromFileNoEndSeparator(String fileDc) {
        File fd = new File(fileDc);
        return getFolderPathFromFileNoEndSeparator(fd);
    }

    public static String getFolderPathFromFileNoEndSeparator(File fileDc) {
        if (fileDc != null) {
            return FilenameUtils.getFullPathNoEndSeparator(fileDc.getAbsolutePath());
            //return absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        }
        return "";
    }

    public static String getFolderPathFromFile(String fileDc) {
        File fd = new File(fileDc);
        return getFolderPathFromFile(fd);
    }

    public static String getFolderPathFromFile(File fileDc) {
        if (fileDc != null) {
            return FilenameUtils.getFullPath(fileDc.getAbsolutePath());
        }
        return "";
    }

    public static InputStream convertToInputStream(String file) {
        try {
            return FileUtils.openInputStream(new File(file));
        } catch (IOException ex) {
            return null;
        }
    }

    public static String getFileExtension(String filePath) {
        return FilenameUtils.getExtension(filePath);
    }
}
