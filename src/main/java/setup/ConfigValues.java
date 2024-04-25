package setup;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:ConfigValues.properties"})
public interface ConfigValues extends Config {
    String hostname();

    String api_key();

    String bc_address();
}
