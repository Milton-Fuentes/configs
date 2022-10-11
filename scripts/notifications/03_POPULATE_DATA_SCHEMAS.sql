--- adm_module
INSERT INTO admin.adm_module(code, name, start_page, version) VALUES ('admin', 'Administration', 'dashboard', 0);
INSERT INTO admin.adm_module(code, name, start_page, version) VALUES ('track_it', 'Track-It', 'dashboard', 0);
INSERT INTO admin.adm_module(code, name, start_page, version) VALUES ('assure_it', 'Assure-It', 'dashboard', 0);
INSERT INTO admin.adm_module(code, name, start_page, version) VALUES ('draw_it', 'Draw-It', 'dashboard', 0);

-- adm_role
-- [***Note**Every User width adm_role.code='administrator'* have full access to the system*]-----
INSERT INTO admin.adm_role(code, name, description, version) VALUES ('administrator', 'System Administrator', 'This role has full access a all the functionalities', 0);
INSERT INTO admin.adm_role(code, name, description, version) VALUES ('user', 'System User', 'This role has access to the regular functionalities', 0);
INSERT INTO admin.adm_role(code, name, description, version) VALUES ('viewer', 'Viewer', 'This role has access to review certain functionalities', 0);

-- adm_functionality
-- INSERT INTO public.adm_functionality(code, name, description, module_id, version) VALUES ('fnc_all_administration', 'admin', 'Has Global Access', (SELECT id FROM admin.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_user_administration', 'view', 'User Details', 'Can View User Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_user_administration', 'delete', 'Delete User', 'Can Delete Users', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_user_administration', 'edit', 'Edit User', 'Can Edit User Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_user_administration', 'create', 'Create User', 'Can Create Users', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
--
--INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_module_administration', 'view', 'Module Details', 'Can View Module Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_module_administration', 'delete', 'Delete Module', 'Can Delete Modules', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_module_administration', 'edit', 'Edit Module', 'Can Edit Module Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_module_administration', 'create', 'Create Module', 'Can Create Modules', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
--												
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_simple_catalog_administration', 'view', 'Catalog Details', 'Can View Catalog Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_simple_catalog_administration', 'delete', 'Delete Catalog', 'Can Delete Catalogs', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_simple_catalog_administration', 'edit', 'Edit Catalog', 'Can Edit Catalog Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_simple_catalog_administration', 'create', 'Create Catalog', 'Can Create Catalogs', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
--												
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_functionalities_administration', 'view', 'Functionality Details', 'Can View Functionality Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_functionalities_administration', 'delete', 'Delete Functionality', 'Can Delete Functionalities', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_functionalities_administration', 'edit', 'Edit Functionality', 'Can Edit Functionality Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_functionalities_administration', 'create', 'Create Functionality', 'Can Create Functionalities', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
--												
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_role_administration', 'view', 'Role Details', 'Can View Role Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_role_administration', 'delete', 'Delete Role', 'Can Delete Roles', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_role_administration', 'edit', 'Edit Role', 'Can Edit Role Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_role_administration', 'create', 'Create Role', 'Can Create Roles', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
--												
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_profile_administration', 'view', 'Profile Details', 'Can View Profile Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_profile_administration', 'delete', 'Delete Profile', 'Can Delete Profiles', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_profile_administration', 'edit', 'Edit Profile', 'Can Edit Profile Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_profile_administration', 'create', 'Create Profile', 'Can Create Profiles', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
--												
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_authorities_administration', 'view', 'Authority Details', 'Can View Authority Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_authorities_administration', 'delete', 'Delete Authority', 'Can Delete Authorities', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_authorities_administration', 'edit', 'Edit Authority', 'Can Edit Authority Information', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);
-- INSERT INTO public.adm_functionality(code, name, display, description, module_id, version) VALUES ('fnc_authorities_administration', 'create', 'Create Authority', 'Can Create Authorities', (SELECT id FROM public.adm_module m WHERE m.code = 'admin'), 0);

--adm_functionality
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_all_administration', 'admin', 'Global Access', 'Has Global Access',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_user_administration', 'view', 'User Details', 'Can View User Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_user_administration', 'delete', 'Delete User', 'Can Delete Users',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_user_administration', 'edit', 'Edit User', 'Can Edit User Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_user_administration', 'create', 'Create User', 'Can Create Users',  0);
																	   
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_module_administration', 'view', 'Module Details', 'Can View Module Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_module_administration', 'delete', 'Delete Module', 'Can Delete Modules',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_module_administration', 'edit', 'Edit Module', 'Can Edit Module Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_module_administration', 'create', 'Create Module', 'Can Create Modules',  0);
																	   
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_simple_catalog_administration', 'view', 'Catalog Details', 'Can View Catalog Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_simple_catalog_administration', 'delete', 'Delete Catalog', 'Can Delete Catalogs',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_simple_catalog_administration', 'edit', 'Edit Catalog', 'Can Edit Catalog Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_simple_catalog_administration', 'create', 'Create Catalog', 'Can Create Catalogs',  0);
																	   
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_functionalities_administration', 'view', 'Functionality Details', 'Can View Functionality Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_functionalities_administration', 'delete', 'Delete Functionality', 'Can Delete Functionalities',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_functionalities_administration', 'edit', 'Edit Functionality', 'Can Edit Functionality Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_functionalities_administration', 'create', 'Create Functionality', 'Can Create Functionalities',  0);
																	   
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_role_administration', 'view', 'Role Details', 'Can View Role Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_role_administration', 'delete', 'Delete Role', 'Can Delete Roles',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_role_administration', 'edit', 'Edit Role', 'Can Edit Role Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_role_administration', 'create', 'Create Role', 'Can Create Roles',  0);
																	   
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_profile_administration', 'view', 'Profile Details', 'Can View Profile Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_profile_administration', 'delete', 'Delete Profile', 'Can Delete Profiles',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_profile_administration', 'edit', 'Edit Profile', 'Can Edit Profile Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_profile_administration', 'create', 'Create Profile', 'Can Create Profiles',  0);
																	   
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_authorities_administration', 'view', 'Authority Details', 'Can View Authority Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_authorities_administration', 'delete', 'Delete Authority', 'Can Delete Authorities',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_authorities_administration', 'edit', 'Edit Authority', 'Can Edit Authority Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_authorities_administration', 'create', 'Create Authority', 'Can Create Authorities',  0);

---fnc_client_administration
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_client_administration', 'view', 'Client Details', 'Can View Client Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_client_administration', 'delete', 'Delete Client', 'Can Delete Client',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_client_administration', 'edit', 'Edit Client', 'Can Edit Client Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_client_administration', 'create', 'Create Client', 'Can Create Client',  0);

--fnc_client_type_administration
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_client_type_administration', 'view', 'Client Type Details', 'Can View Client Type Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_client_type_administration', 'delete', 'Delete Client Type', 'Can Delete Client Type',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_client_type_administration', 'edit', 'Edit Client Type', 'Can Edit Client Type Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_client_type_administration', 'create', 'Create Client Type', 'Can Create Client Type',  0);

--fnc_menu_administration
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_administration', 'view', 'Menu Details', 'Can View Menu Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_administration', 'delete', 'Delete Menu', 'Can Delete Menu',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_administration', 'edit', 'Edit Menu', 'Can Edit Menu Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_administration', 'create', 'Create Menu', 'Can Create Menu',  0);

--fnc_menu_type_administration
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_type_administration', 'view', 'Type Menu Details', 'Can View Type Menu Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_type_administration', 'delete', 'Delete Type Menu', 'Can Delete Type Menu',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_type_administration', 'edit', 'Edit Type Menu', 'Can Edit Type Menu Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_type_administration', 'create', 'Create Type Menu', 'Can Create Type Menu',  0);

--fnc_project_administration
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_project_administration', 'view', 'Project Details', 'Can View Project Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_project_administration', 'delete', 'Delete Project', 'Can Delete Project',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_project_administration', 'edit', 'Edit Project', 'Can Edit Project Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_project_administration', 'create', 'Create Project', 'Can Create Project',  0);

--fnc_region_administration
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_region_administration', 'view', 'Region Details', 'Can View Region Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_region_administration', 'delete', 'Delete Region', 'Can Delete Regions',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_region_administration', 'edit', 'Edit Region', 'Can Edit Region Information',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_region_administration', 'create', 'Create Region', 'Can Create Regions',  0);


--fnc_[menu]_frontend_list
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_region_frontend', 'list', 'Crud Region', 'Can access to the Component Region List',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_project_frontend', 'list', 'Crud Project', 'Can access to the Component Project List',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_type_frontend', 'list', 'Crud Type Menu', 'Can access to the Component Type Menu List',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_menu_frontend', 'list', 'Crud Menu', 'Can access to the Component Menu List',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_user_frontend', 'list', 'Crud User', 'Can access to the Component User List',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_module_frontend', 'list', 'Crud Module', 'Can access to the Component Module List',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_client_frontend', 'list', 'Curd Client', 'Can access to the Component Client List',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_simple_catalog_frontend', 'list', 'Crud Simple Catalog', 'Can access to the Component Simple Catalog List',  0);
INSERT INTO admin.adm_functionality(code, name, display, description, version) VALUES ('fnc_role_frontend', 'list', 'Crud Role', 'Can access to the Component Role List',  0);





--==========================================================
-- adm_user [pass: admin10]
INSERT INTO admin.adm_user(username, password, email, version) VALUES ('admin_root', '$2a$12$7IX/yRWa91N8gYBm8CCIMuNauIRGYnRf8EQpEIuMi7KQTFRSs7Fni', 'admin@atser.com', 0);

-- adm_authority
-- INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'view' AND f.module_id = (SELECT id FROM admin.adm_module m WHERE m.code = 'admin')), (SELECT ID FROM admin.adm_role r WHERE r.code = 'user'), true, 0);
-- INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'delete' AND f.module_id = (SELECT id FROM admin.adm_module m WHERE m.code = 'admin')), (SELECT ID FROM admin.adm_role r WHERE r.code = 'user'), true, 0);
-- INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'edit' AND f.module_id = (SELECT id FROM admin.adm_module m WHERE m.code = 'admin')), (SELECT ID FROM admin.adm_role r WHERE r.code = 'user'), true, 0);
-- INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'create' AND f.module_id = (SELECT id FROM admin.adm_module m WHERE m.code = 'admin')), (SELECT ID FROM admin.adm_role r WHERE r.code = 'user'), true, 0);

-- adm_authority
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'view' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'user'), true, 0);
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'delete' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'user'), true, 0);
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'edit' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'user'), true, 0);
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'create' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'user'), true, 0);

-- adm_authority viewer
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'view' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'viewer'), true, 0);
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'delete' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'viewer'), true, 0);
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'edit' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'viewer'), true, 0);
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'create' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'viewer'), true, 0);

-- adm_authority administrator
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'view' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'administrator'), true, 0);
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'delete' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'administrator'), true, 0);
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'edit' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'administrator'), true, 0);
INSERT INTO admin.adm_authority(functionality_id, role_id, has_right, version) VALUES ((SELECT ID FROM admin.adm_functionality f WHERE f.code = 'fnc_user_administration' AND f.name = 'create' ), (SELECT ID FROM admin.adm_role r WHERE r.code = 'administrator'), true, 0);

-- company
INSERT INTO admin.adm_company(code, name, description, created_by, creation_date, last_update, last_update_by, enabled, deleted, version)
	VALUES ('atser', 'ATSER System Inc.', 'ATSER - Building in real time.', (select id from admin.adm_user where username = 'admin_root'), CURRENT_DATE, CURRENT_DATE, (select id from admin.adm_user where username = 'admin_root'), true, false, 1);
			
-- client
INSERT INTO admin.adm_client(company_id, code, name, description, created_by, creation_date, last_update, last_update_by, enabled, deleted, version)
	VALUES ((select id from admin.adm_company where code = 'atser'), 'atser', 'ATSER System Inc.', 'ATSER - Building in real time.', (select id from admin.adm_user where username = 'admin_root' AND deleted = false), CURRENT_DATE, CURRENT_DATE, (select id from admin.adm_user where username = 'admin_root' AND deleted = false), true, false, 1);

-- adm_profile
INSERT INTO admin.adm_profile(client_id, user_id, role_id, version) VALUES ((select id from admin.adm_client where code = 'atser'), (SELECT u.id FROM admin.adm_user u WHERE u.username = 'admin_root' AND u.deleted = false), (SELECT r.id FROM admin.adm_role r WHERE r.code = 'administrator' AND r.deleted = false),0);
INSERT INTO admin.adm_profile(client_id, user_id, role_id, version) VALUES ((select id from admin.adm_client where code = 'atser'), (SELECT u.id FROM admin.adm_user u WHERE u.username = 'admin_root' AND u.deleted = false), (SELECT r.id FROM admin.adm_role r WHERE r.code = 'user' AND r.deleted = false),0);

-- adm_client type
-- INSERT INTO admin.adm_client_type (code, name, description) VALUES ('commercial', 'Commercial', 'Commercial');
INSERT INTO admin.adm_simple_catalog(parent_id, client_id, code, name, description, editable, c_order, created_by, creation_date, last_update, last_update_by, enabled, deleted, version) 
VALUES (null, (select id from admin.adm_client where code = 'atser'), 'client_type', 'Client Type', 'Type of clients in the system.', false, null, (select id from admin.adm_user where username = 'admin_root' AND deleted = false), CURRENT_DATE, CURRENT_DATE, (select id from admin.adm_user where username = 'admin_root' AND deleted = false), true, false, 1);
	INSERT INTO admin.adm_simple_catalog(parent_id, client_id, code, name, description, editable, c_order, created_by, creation_date, last_update, last_update_by, enabled, deleted, version)
	VALUES ((select id from admin.adm_simple_catalog where code = 'client_type'), (select id from admin.adm_client where code = 'atser'), 'commercial', 'Comercial', 'Commercial Client', false, null, (select id from admin.adm_user where username = 'admin_root' AND deleted = false), CURRENT_DATE, CURRENT_DATE, (select id from admin.adm_user where username = 'admin_root' AND deleted = false), true, false, 1);


