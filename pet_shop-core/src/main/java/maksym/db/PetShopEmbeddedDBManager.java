package maksym.db;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.Sources;
import com.wix.mysql.SqlScriptSource;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.distribution.Version;

import java.io.File;

public class PetShopEmbeddedDBManager {

    private static final String SCHEMA_NAME = "PetShop";
    private static final String SCRIPT_FILE_NAME = "PetShop.sql";
    private static final String USER_NAME = "Maksym";
    private static final String PASSWORD = "pwEzhF258YPjZUG8";

    private static PetShopEmbeddedDBManager INSTANCE;

    public static PetShopEmbeddedDBManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PetShopEmbeddedDBManager();
        }
        return INSTANCE;
    }

    private EmbeddedMysql mysqld;

    private PetShopEmbeddedDBManager() {
    }

    public void start() {
        MysqldConfig config = MysqldConfig.aMysqldConfig(Version.v5_7_10)
                .withPort(3306)
                .withUser(USER_NAME, PASSWORD)
                .build();
        mysqld = EmbeddedMysql.anEmbeddedMysql(config)
                .addSchema(SCHEMA_NAME)
                .start();
    }

    public void init() {
        if (mysqld == null) {
            return;
        }

        File scriptFile = new File(getClass().getClassLoader().getResource(SCRIPT_FILE_NAME).getFile());
        SqlScriptSource startScript = Sources.fromFile(scriptFile);
        mysqld.executeScripts(SCHEMA_NAME, startScript);
    }

    public void stop() {
        if (mysqld == null) {
            return;
        }
        mysqld.stop();
    }
}
