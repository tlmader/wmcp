package wmcp.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * Description.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/26/2016
 */
public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate5Module());
    }
}
