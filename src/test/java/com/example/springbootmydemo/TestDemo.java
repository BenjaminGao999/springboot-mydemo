package com.example.springbootmydemo;

import com.example.springbootmydemo.domain.TbBean;
import com.example.springbootmydemo.utils.TimeUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author benjamin
 * created at 2019/4/29
 */
public class TestDemo {

    /**
     * 2019-04-19 00:21:27
     * 2019-04-29 18:37:04.833
     */
    @Test
    public void test() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp);
    }

    @Test
    public void utf8Compare() {
        String utf8 = "\u9004\u4ec1\u79c0";
        System.out.println(utf8);

        System.out.println("逄仁秀".equalsIgnoreCase(utf8));
    }


    /*


    <script>
    INSERT INTO app_order_staging(id,order_id,order_no,period,plan_repayment_money,plan_repaymnet_time,plan_repaymnet_time_text,principal,interest,actual_repayment_money,actual_repayment_time,actual_repayment_time_text,overdue_days,overdue_fee,status)
     VALUES
      <foreach collection="appOrderStagingList" item="item" index="index" separator="," open="" close="" >
         (#{item.orderId}, #{item.orderNo}, #{item.period}, #{item.planRepaymentMoney}, #{item.planRepaymnetTime}, #{item.planRepaymnetTimeText}, #{item.principal}, #{item.interest}, #{item.actualRepaymentMoney}, #{item.actualRepaymentTime}, #{item.actualRepaymentTimeText}, #{item.overdueDays}, #{item.overdueFee}, #{item.status})
          </foreach>

          on duplicate key update plan_repayment_money=values(plan_repayment_money);

          </script>



<script>
    insert into app_statistic ( os, app_market_channel, package_name, phone,app_version, udid, customer_id, gmt_timestamp, type, page, page_position, product_type, product_id )
    VALUES
    <foreach collection="list" item="item" index="index" open="" separator=","  close="">
     ( #{item.os,jdbcType=INTEGER},
      #{item.appMarketChannel,jdbcType=VARCHAR},
      #{item.packageName,jdbcType=VARCHAR},
       #{item.phone,jdbcType=VARCHAR},
      #{item.appVersion,jdbcType=VARCHAR},
      #{item.udid,jdbcType=VARCHAR},
      #{item.customerId,jdbcType=INTEGER},
      #{item.gmtTimestamp,jdbcType=TIMESTAMP},
      #{item.type,jdbcType=INTEGER},
      #{item.page,jdbcType=INTEGER},
      #{item.pagePosition,jdbcType=INTEGER},
       #{item.productType,jdbcType=INTEGER},
        #{item.productId,jdbcType=INTEGER})
       </foreach>
       on duplicate key update gmt_timestamp=values(gmt_timestamp);
</script>


<script>

 SELECT SUM(a.count) as registration,s.parent_id as partnerId

FROM

(SELECT partner_id as partnerId, COUNT(0) as count FROM app_customer WHERE gmt_created >= #{start} and gmt_created &lt; #{end} and partner_id != 0 GROUP BY partner_id) a

LEFT JOIN sys_partner s

on a.partnerId = s.id

GROUP BY s.parent_id


</script>


    */

    @Test
    public void log() {

        String log = "<script>" +
                "INSERT INTO app_order_staging(id,order_id,order_no,period,plan_repayment_money,plan_repaymnet_time,plan_repaymnet_time_text,principal,interest,actual_repayment_money,actual_repayment_time,actual_repayment_time_text,overdue_days,overdue_fee,status) " +
                "VALUES" +
                "   <foreach collection=\"appOrderStagingList\" item=\"item\" index=\"index\" separator=\",\" open=\"\" close=\"\" >" +
                "     (#{item.orderId}, #{item.orderNo}, #{item.period}, #{item.planRepaymentMoney}, #{item.planRepaymnetTime}, #{item.planRepaymnetTimeText}, #{item.principal}, #{item.interest}, #{item.actualRepaymentMoney}, #{item.actualRepaymentTime}, #{item.actualRepaymentTimeText}, #{item.overdueDays}, #{item.overdueFee}, #{item.status})" +
                "   </foreach> " +
                "on duplicate key update plan_repayment_money=values(plan_repayment_money);" +
                "</script>";

        String log2 = "<script>\n" +
                "    insert into app_statistic ( os, app_market_channel, package_name, phone,app_version, udid, customer_id, gmt_timestamp, type, page, page_position, product_type, product_id )\n" +
                "    VALUES\n" +
                "    <foreach collection=\"list\" item=\"item\" index=\"index\" open=\"\" separator=\",\"  close=\"\">\n" +
                "     ( #{item.os,jdbcType=INTEGER},\n" +
                "      #{item.appMarketChannel,jdbcType=VARCHAR},\n" +
                "      #{item.packageName,jdbcType=VARCHAR},\n" +
                "       #{item.phone,jdbcType=VARCHAR},\n" +
                "      #{item.appVersion,jdbcType=VARCHAR},\n" +
                "      #{item.udid,jdbcType=VARCHAR},\n" +
                "      #{item.customerId,jdbcType=INTEGER},\n" +
                "      #{item.gmtTimestamp,jdbcType=TIMESTAMP},\n" +
                "      #{item.type,jdbcType=INTEGER},\n" +
                "      #{item.page,jdbcType=INTEGER},\n" +
                "      #{item.pagePosition,jdbcType=INTEGER},\n" +
                "       #{item.productType,jdbcType=INTEGER},\n" +
                "        #{item.productId,jdbcType=INTEGER})\n" +
                "       </foreach>\n" +
                "       on duplicate key update gmt_timestamp=values(gmt_timestamp);\n" +
                "</script>";


        String log3 = "<script> " +
                "SELECT SUM(a.count) as registration,s.parent_id as partnerId " +
                "FROM (SELECT partner_id as partnerId, COUNT(0) as count " +
                "FROM app_customer " +
                "WHERE gmt_created >= #{start} and gmt_created &lt; #{end} and partner_id != 0 " +
                "GROUP BY partner_id) a LEFT JOIN sys_partner s on a.partnerId = s.id " +
                "GROUP BY s.parent_id " +
                "</script>";

        System.out.println(log3);


    }

    @Test
    public void calandarTest() {


        long start = TimeUtils.start(-1);
        System.out.println(start);
        long end = TimeUtils.end(-1);
        System.out.println(end);

        System.out.println(new Timestamp(start).toString());

        System.out.println(new Timestamp(end).toString());

    }


    @Test
    public void testlocaldatetime() {

        LocalDateTime localdatetimeStart = TimeUtils.localdatetimeStart();
        System.out.println(localdatetimeStart);

        LocalDateTime localdatetimeEnd = TimeUtils.localdatetimeEnd();
        System.out.println(localdatetimeEnd);

    }

    @Test
    public void tbbean() {

        TbBean tbBean = new TbBean();

        //java.lang.NullPointerException
        // 因为要拆箱
        if (tbBean.getId() > 0) {

        }
    }

    @Test
    public void timeClockTest() {

        long startClock = TimeUtils.startClock();

        long endNextClock = TimeUtils.endNextClock();

        System.out.println(new Timestamp(startClock).toString());

        System.out.println(new Timestamp(endNextClock).toString());

    }

    @Test
    public void xTimeStamp() {

        /*



-- 1559026800
SELECT UNIX_TIMESTAMP('2019-05-28 15:00:00')

-- 1559030400
SELECT UNIX_TIMESTAMP('2019-05-28 16:00:00')



         */


        Timestamp start = new Timestamp(1559026800000L);

        Timestamp end = new Timestamp(1559030400000L);

        System.out.println(start.toString());

        System.out.println(end.toString());

    }


}
