package cn.work.config.orm;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * MySQLDialectUTF8 Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-12 18:40
 */
public class MySQLDialectUTF8 extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
