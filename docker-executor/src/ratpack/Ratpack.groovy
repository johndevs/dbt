import com.devsoap.dbt.modules.DBTExecutorModule
import com.devsoap.dbt.services.LedgerService
import com.devsoap.dbt.services.MongoLedgerService
import org.h2.jdbcx.JdbcDataSource
import org.slf4j.LoggerFactory

import javax.sql.DataSource

import static ratpack.groovy.Groovy.ratpack

def log = LoggerFactory.getLogger('dbt-executor')

ratpack {
    serverConfig {
        env()
        sysProps()
    }

    bindings {
        bindInstance(DataSource, new JdbcDataSource(url: 'jdbc:h2:mem:dbtdb;DB_CLOSE_DELAY=-1', user: ''))
        module (DBTExecutorModule)
    }
}
