import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

//public class testAPI {
////静态方法，（DDL与DML）创删表,增删改查数据
//    public static boolean isTableExist(String tableName) throws IOException {
//        //获取配置文件信息
//        HBaseConfiguration configuration = new HBaseConfiguration();
//        //集群信息
//        configuration.set("hbase.rootdir","hdfs://hadoop100:9000/hbase");
//        //client信息
//        HBaseAdmin admin = new HBaseAdmin(configuration);
//        //判断表是否存在
//        boolean exists = admin.tableExists(TableName.valueOf(tableName));
//        //关闭连接
//        admin.close();
//        //返回结果
//        return exists;
//
//    }
//    public static void main(String[] args) throws IOException {
////测试判断表是否存在
//        System.out.printf(isTableExist("student"));
//
//    }
//}
