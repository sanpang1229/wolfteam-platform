package com.wolfteam.plugins.utils.auto;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月18日  下午5:34:44 类说明 
 *			根据接口文档 自动生成SQL 语句（文档是word的 可以直接复制到txt中 就是下面的 txt格式 自己稍微改下）
 * @version 0.1
 * 
 */
public class AcordApiCreateSql {

    private String filePath = "G:\\sql\\database.txt";
    //private String filePath = "/Users/maxbin/Documents/createSQL";
    private static StringBuilder sbuild = new StringBuilder();
    private static List list = new ArrayList();
    private static Set s   = new HashSet();

    /*@Test*/
    public void testReadFile(){
        File file = new File(filePath);
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
        }catch (Exception e){

        }


    }

   /* @Test*/
    public void test(){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader fin =  new BufferedReader( new FileReader(filePath));
            String ss=fin.readLine();
            while(ss!=null){
                if (ss.contains("table:")){
                    String[] ll = ss.split(":");
                    sb.append("CREATE TABLE `" + ll[1] + "` (\n ");
                }else if (ss.startsWith("tableend")){
                    sb.append("PRIMARY KEY (`Id`)\n" +
                            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
                    System.out.println(sb.toString());
                    sb = new StringBuilder();
                }else if(ss.length()>2) {
                    String[] strArr = ss.split("	");
                    sb.append("`"+strArr[0]+"` ");
                    String val = strArr[2];
                    if(val.startsWith("INT")){
                        sb.append("INT("+ strArr[3] +") ");
                    }else if(val.startsWith("TIMESTAMP")){
                        sb.append("timestamp ");
                    }else if(val.startsWith("DECIMAL")){
                        sb.append("DECIMAL("+ strArr[3] +") ");
                    }else{
                        sb.append("varchar("+ strArr[3] +") ");
                    }
                    sb.append("NOT NULL ");
                    if(strArr[0].startsWith("Id")||strArr[0].startsWith("id")){
                        sb.append("AUTO_INCREMENT ");
                    }
                    sb.append("COMMENT '"+ strArr[1] +"',\n");
                }
                //System.out.print(ss);
                ss=fin.readLine();

            }}
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * CREATE TABLE `UC_USER` (
     `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',r
     `UserNo` varchar(20) NOT NULL COMMENT '用户编号',
     `NickName` varchar(20) NOT NULL COMMENT '用户昵称',
     `LoginName` varchar(20) NOT NULL COMMENT '登录名称',
     `Password` varchar(50) NOT NULL COMMENT '登录密码',
     `DealPassword` varchar(50) NOT NULL COMMENT '交易密码',
     `Salt` varchar(20) NOT NULL COMMENT 'MD盐',
     `Status` int(2) NOT NULL COMMENT '用户状态',
     `UserType` int(2) NOT NULL COMMENT '用户类型',
     `Avatar` varchar(255) NOT NULL COMMENT '用户头像',
     `IsBindMobile` int(1) NOT NULL COMMENT '是否绑定手机',
     `IsBindeMail` int(1) NOT NULL COMMENT '是否绑定邮箱',
     `IsRealName` int(1) NOT NULL COMMENT '是否实名',
     `IsBindCard` int(1) NOT NULL COMMENT '是否绑卡',
     `IsSetDealPassword` int(1) NOT NULL COMMENT '是否设置交易密码',
     `RegistTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
     `CreateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
     `CreateBy` varchar(20) NOT NULL COMMENT '创建人',
     `UpdateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
     `UpdateBy` varchar(20) NOT NULL COMMENT '修改人',
     `DeleteFlag` int(1) NOT NULL COMMENT '是否删除',
     PRIMARY KEY (`Id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
     */
    // 文件格式 将word　中的表格复制的ｔｘｔｓｕｂｌｉｎｅ　中　直接就是下面的格式　createSQL。txt
  /**
     * table:OC_ORDER
Id   主键   INT   11   
OrderBizNo   订单编号   VARCHAR   20   
ProductId   产品ID   INT   20   
ProductName   产品名称   VARCHAR   100   
UserId   用户ID   INT   20   
OrderStatus   订单状态   INT   2   成功失败
PayStatus   支付状态   INT   2
CertificateStatus   登记状态   INT   2    
OrderDesc   描述   VARCHAR   100       
Amount   订单金额   DECIMAL   18,2   
OrderTime   下单时间   TIMESTAMP   14   
ExpireTime   过期时间   TIMESTAMP   14   
CancelTime   取消时间   TIMESTAMP   14   
CancelBy   取消人   VARCHAR   20   
RefundApplyTime   退款申请时间   TIMESTAMP   14   
RefundTime   退款时间   TIMESTAMP   14   
RefundBy   退款人   TIMESTAMP   14   
RefundAmount   退款金额   DECIMAL   18,2   
CreateTime   创建时间   TIMESTAMP   14   
CreateBy   创建人   VARCHAR   20   
UpdateTime   修改时间   TIMESTAMP   14   
UpdateBy   修改人   VARCHAR   20   
DeleteFlag   删除标志   INT   1   
tableend
table:OC_PAYMENT_ORDER
Id   主键   INT   11   
OrderId   订单主键   INT   11   
PaymentBizNo   支付   VARCHAR   20   
PaymentThirdNo   第三方支付号   VARCHAR   64   
PaymentType   支付类型   INT   2   
Amount   支付金额   DECIMAL   18,2   订单金额=支付金额+现金券
PayTime   支付时间   TIMESTAMP   14   
PayStutas   支付状态   INT   2   支付成功，失败
RefundStatus   退款状态   INT   2  
PayDesc   支付备注   VARCHAR   120   
CancelTime   取消时间   TIMESTAMP   14   
CancelBy   取消人   VARCHAR   20   
RefundApplyTime   退款申请时间   TIMESTAMP   14   
RefundTime   退款时间   TIMESTAMP   14   
RefundBy   退款人   varchar   14   
RefundAmount   退款金额   DECIMAL   18,2   
CreateTime   创建时间   TIMESTAMP   14   
CreateBy   创建人   VARCHAR   20   
UpdateTime   修改时间   TIMESTAMP   14   
UpdateBy   修改人   VARCHAR   20   
DeleteFlag   删除标志   INT   1   
tableend
table:OC_ORDER_LOG
Id   主键   INT   11   
OrderId   订单主键   INT   11   
OrderNo   订单编号   VARCHAR   20   
StatusBefore   变更前状态   INT   2   
StatusAfter   变更后状态   INT   2   
LogDesc   日志描述   VARCHAR   255   
OprUserNo   变更人   VARCHAR   20   
CreateTime   创建时间   TIMESTAMP   14   
CreateBy   创建人   VARCHAR   20   
tableend
table:SM_SHORT_MSG
Id   主键   INT   11            
Phone   手机号   CHAR   15   
Content   短信内容   VARCHAR   240
SendType   发送业务类型   INT   3   注册,忘记密码,站内信
SendTime   发送时间   TIMESTAMP   
SendStatus   发送状态   INT   2
MsgDesc   发送描述   VARCHAR   120  
tableend
     * 
     * 
     * */
}
