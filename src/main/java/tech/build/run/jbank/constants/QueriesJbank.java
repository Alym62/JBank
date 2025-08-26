package tech.build.run.jbank.constants;

/**
 * @author Alyasaf Meireles
 * Um utilitário que vai servir para todas as queries do projeto JBank
 * para utilização de queries personalizadas via Spring
 */
public class QueriesJbank {
    public final static String SQL_STATEMENT = """
            select code_transfer as statement_id,
                   'transfer' as type,
                   value_transfer as statement_value,
                   wallet_receiver_id as wallet_receiver,
                   currentdate_transfer as statement_date_time
            from tb_transfer
            where wallet_receiver_id = ?1
            union all select code_deposit as statement_id,
                             'deposit' as type,
                             value_deposit as statement_value,
                             wallet_id as wallet_receiver,
                             currentdate_deposit as statement_date_time
            from tb_deposit
            where wallet_id = ?1
            """;

    public final static String SQL_COUNT_STATEMENT = """
            select count(*) from (
            """ + SQL_STATEMENT + """
            ) as total
            """;

    private QueriesJbank() {}
}
