/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.sp;

import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.gateway.EstimateAnalysisTO;
import com.atser.tools.atserutil.objects.to.gateway.TotalEstimateAnalysisTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EstimateAnalysisDaoImpl implements EstimateAnalysisDao {

    @PersistenceContext(unitName = "com.atser.tools_atseree-ejb_ejb_0.1.0PU")
    EntityManager em;

    @Override
    public TotalEstimateAnalysisTO filter(BigDecimal contractId, String startdate, String enddate) {
        String query = "SELECT contract_id, \n"
                + "         plan-nvl((select sum(change_order_addq) from cm_change_order,cm_change_orderitem where cm_change_order.id=cm_change_orderitem.change_order_id and item_no= a.item_no  and nvl(item_desc,'~')=nvl(a.item_desc,'~')  and nvl(category,'~')=nvl(a.category,'~')   and cm_change_order.status='Approved'   and cm_change_order.contract_id=a.contract_id),0) orig_plan,\n"
                + "         bid_item_id,item_no,item_desc,item_no || item_desc as item_rb,category,description,unit,plan,unit_price, totalqt1 ,totalqt1*unit_price AS totalamt1, totalqtd2,totalqtd2*unit_price AS totalamt2, to_char(decode(plan,0,0,100*totalqtd2/plan),'999990.9999') as comp, \n"
                + "                   case when decode(plan,0,0,100*totalqtd2/plan)>=110 Then 1 else 0 end red_flag, \n"
                + "                   case when decode(plan,0,0,100*totalqtd2/plan)>100 Then nvl((totalqtd2-plan)*unit_price,0) else 0 End overrun, \n"
                + "                   case when decode(plan,0,0,100*totalqtd2/plan)<100 Then nvl((plan-totalqtd2)*unit_price,0) else 0 End underrun, \n"
                + "                   case when decode(plan,0,0,100*totalqtd2/plan)<100  Then nvl((plan-totalqtd2),0) else 0 End qty_underrun, \n"
                + "                   case when decode(plan,0,0,100*totalqtd2/plan)>100 Then nvl((totalqtd2-plan),0) else 0 End qty_overrun, \n"
                + "                   case when decode(plan,0,0,100*totalqtd2/plan)<>100 Then nvl((totalqtd2-plan),0)*unit_price else 0 End cost_delta, \n"
                + "                   case when decode(plan,0,0,100*totalqtd2/plan)<>100 Then nvl((totalqtd2-plan),0) else 0 End qty_delta \n"
                + "                 FROM \n"
                + "                 (\n"
                + "		 SELECT\n"
                + "                    contract_id, bid_item_id,item_no,item_desc,category,description,unit,plan,unit_price,SUM(totalqt) AS totalqt1 ,SUM(totalqtd) AS totalqtd2\n"
                + "                FROM\n"
                + "                  (\n"
                + "		SELECT cm_bid_item.contract_id, cm_bid_item.id bid_item_id, cm_bid_item.item_no,cm_bid_item.item_desc, cm_bid_item.category, cm_bid_item.description, cm_bid_item.unit, cm_bid_item.plan,\n"
                + "                       cm_bid_item.unit_price, 0 AS TotalQT, 0 AS TotalQTD \n"
                + "				FROM cm_bid_item \n"
                + "				WHERE cm_bid_item.contract_id=:CONTRACTID\n"
                + "				UNION\n"
                + "				SELECT cm_bid_item.contract_id, cm_bid_item.id, cm_bid_item.item_no,cm_bid_item.item_desc, cm_bid_item.category, cm_bid_item.description, cm_bid_item.unit, cm_bid_item.plan, cm_bid_item.unit_price,\n"
                + "                      SUM(cm_daily_work.quantity) AS TotalQT, SUM(0) AS TotalQTD \n"
                + "                FROM cm_daily_work, cm_bid_item, cm_daily_report\n"
                + "                WHERE\n"
                + "                      cm_daily_work.bid_item_id = cm_bid_item.id AND cm_daily_report.id = cm_daily_work.daily_report_id AND cm_daily_report.report_date>=to_date(:STARTDATE,'mm/dd/yyyy')\n"
                + "                       AND cm_daily_report.report_date<=to_date(:ENDDATE,'mm/dd/yyyy') AND cm_bid_item.contract_id=:CONTRACTID\n"
                + "                GROUP BY\n"
                + "                      cm_bid_item.contract_id, cm_bid_item.id, cm_bid_item.item_no,cm_bid_item.item_desc, cm_bid_item.category, cm_bid_item.description, cm_bid_item.unit, cm_bid_item.plan, cm_bid_item.unit_price\n"
                + "				UNION\n"
                + "				SELECT  cm_bid_item.contract_id,  cm_bid_item.id, cm_bid_item.item_no,cm_bid_item.item_desc, cm_bid_item.category, cm_bid_item.description, cm_bid_item.unit, cm_bid_item.plan, cm_bid_item.unit_price,\n"
                + "					SUM(0) AS TotalQT, SUM(cm_daily_work.quantity) AS TotalQTD\n"
                + "			   FROM\n"
                + "					cm_daily_work, cm_bid_item, cm_daily_report \n"
                + "				WHERE\n"
                + "					cm_daily_work.bid_item_id = cm_bid_item.id  AND cm_daily_report.id = cm_daily_work.daily_report_id  AND cm_bid_item.contract_id=:CONTRACTID\n"
                + "			   GROUP BY\n"
                + "					cm_bid_item.contract_id, cm_bid_item.id, cm_bid_item.item_no,item_desc, cm_bid_item.category, cm_bid_item.description, cm_bid_item.unit, cm_bid_item.plan, cm_bid_item.unit_price\n"
                + "                      )\n"
                + "                GROUP BY\n"
                + "                   contract_id, bid_item_id,item_no,item_desc,category,description,unit,plan,unit_price\n"
                + "                ) a ORDER BY item_no,item_desc";

        List<Object[]> objects = em.createNativeQuery(query)
                .setParameter("CONTRACTID", contractId)
                .setParameter("STARTDATE", startdate)
                .setParameter("ENDDATE", enddate)
                .getResultList();
        return populateEstimateAnalysisTO(objects);
    }
    
    private TotalEstimateAnalysisTO populateEstimateAnalysisTO(List<Object[]> objects) {
        List<EstimateAnalysisTO> list = new ArrayList<>();
        TotalEstimateAnalysisTO response = new TotalEstimateAnalysisTO();

        objects.stream().map((it) -> {
            EstimateAnalysisTO to = new EstimateAnalysisTO();
            to.setItemNo(NumberSupport.getBigInteger(it[5]));
            to.setDescriptionCode(StringSupport.emptyOnNull(it[6]));
            to.setDescription(StringSupport.emptyOnNull(it[7]));
            to.setUnit(StringSupport.emptyOnNull(it[8]));
            to.setOriginalQty(NumberSupport.getBigDecimal(it[1]));
            to.setCurrentQty(NumberSupport.getBigDecimal(it[9]));
            to.setUnitPrice(CurrencySupport.formatBigDecimal(NumberSupport.getBigDecimal(it[10]), 2));
            to.setRangeQty(NumberSupport.getBigDecimal(it[11]));
            to.setRangeAmount(CurrencySupport.formatBigDecimal(NumberSupport.getBigDecimal(it[12]), 2));
            to.setTotalamt1(NumberSupport.getBigDecimal(it[12]));
            to.setQtyEarnedToDate(NumberSupport.getBigDecimal(it[13]));
            to.setAmountEarnedToDate(CurrencySupport.formatBigDecimal(NumberSupport.getBigDecimal(it[14]), 2));
            to.setTotalamt2(NumberSupport.getBigDecimal(it[14]));
            to.setPercentComp(NumberSupport.getBigDecimal(it[15]));
            to.setTotalQtyDifference(NumberSupport.getBigDecimal(it[22]));
            to.setTotalCostDifference(CurrencySupport.formatBigDecimal(NumberSupport.getBigDecimal(it[21]), 2));
            to.setCost_delta(NumberSupport.getBigDecimal(it[21]));
            return to;
        }).forEachOrdered((to) -> {
            list.add(to);
        });

        response.setList(list);

        response.setRangeAmountTotal(CurrencySupport.formatBigDecimal(list.stream().map(EstimateAnalysisTO::getTotalamt1).reduce(BigDecimal.ZERO, BigDecimal::add), 2));
        response.setAmountEarnedTotal(CurrencySupport.formatBigDecimal(list.stream().map(EstimateAnalysisTO::getTotalamt2).reduce(BigDecimal.ZERO, BigDecimal::add), 2));
        response.setCostTotal(CurrencySupport.formatBigDecimal(list.stream().map(EstimateAnalysisTO::getCost_delta).reduce(BigDecimal.ZERO, BigDecimal::add), 2));

        return response;
    }
}
