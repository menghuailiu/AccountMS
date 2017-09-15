package greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import patrickstar.com.accountms.model.tb_inaccount;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TB_INACCOUNT".
*/
public class tb_inaccountDao extends AbstractDao<tb_inaccount, Long> {

    public static final String TABLENAME = "TB_INACCOUNT";

    /**
     * Properties of entity tb_inaccount.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Money = new Property(1, Double.class, "money", false, "MONEY");
        public final static Property Time = new Property(2, String.class, "time", false, "TIME");
        public final static Property Type = new Property(3, String.class, "type", false, "TYPE");
        public final static Property Handler = new Property(4, String.class, "handler", false, "HANDLER");
        public final static Property Mark = new Property(5, String.class, "mark", false, "MARK");
    };


    public tb_inaccountDao(DaoConfig config) {
        super(config);
    }
    
    public tb_inaccountDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TB_INACCOUNT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"MONEY\" REAL," + // 1: money
                "\"TIME\" TEXT," + // 2: time
                "\"TYPE\" TEXT," + // 3: type
                "\"HANDLER\" TEXT," + // 4: handler
                "\"MARK\" TEXT);"); // 5: mark
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TB_INACCOUNT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, tb_inaccount entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Double money = entity.getMoney();
        if (money != null) {
            stmt.bindDouble(2, money);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(3, time);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(4, type);
        }
 
        String handler = entity.getHandler();
        if (handler != null) {
            stmt.bindString(5, handler);
        }
 
        String mark = entity.getMark();
        if (mark != null) {
            stmt.bindString(6, mark);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, tb_inaccount entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Double money = entity.getMoney();
        if (money != null) {
            stmt.bindDouble(2, money);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(3, time);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(4, type);
        }
 
        String handler = entity.getHandler();
        if (handler != null) {
            stmt.bindString(5, handler);
        }
 
        String mark = entity.getMark();
        if (mark != null) {
            stmt.bindString(6, mark);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public tb_inaccount readEntity(Cursor cursor, int offset) {
        tb_inaccount entity = new tb_inaccount( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getDouble(offset + 1), // money
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // time
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // type
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // handler
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // mark
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, tb_inaccount entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMoney(cursor.isNull(offset + 1) ? null : cursor.getDouble(offset + 1));
        entity.setTime(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setType(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setHandler(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMark(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(tb_inaccount entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(tb_inaccount entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
