package utils;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public enum ConfigFileHelper {
    INSTANCE;
    public String readProperty(String key) {

        CompositeConfiguration configuration = new CompositeConfiguration();
        try {
            configuration.addConfiguration(new PropertiesConfiguration(System.getProperty("user.dir") + "/test.properties"));
        } catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return configuration.getProperty(key).toString();

    }

    public String readAccountProperty(String key) {
        CompositeConfiguration configuration = new CompositeConfiguration();
        try {
            configuration.addConfiguration(new PropertiesConfiguration("/home/luigig/workspace/MediaGalaxy/account.properties"));
        } catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return configuration.getProperty(key).toString();

    }

    public void addRandomToConfig() throws ConfigurationException {
        PropertiesConfiguration configuration = new PropertiesConfiguration("/home/luigig/workspace/MediaGalaxy/account.properties");
        CompositeConfiguration config = new CompositeConfiguration(configuration);
        config.setProperty("email", "test" + System.currentTimeMillis() + "@mailforspam.com");
        config.setProperty("username", "test" + System.currentTimeMillis());
        configuration.save();
    }

    public Cont loadAccountFromConfig() throws ConfigurationException {
        addRandomToConfig();
        System.out.println("email =" + readAccountProperty("email"));
        System.out.println("username =" + readAccountProperty("username"));
        Cont cont = new Cont.ContBuilder().withNume(readAccountProperty("nume")).withPrenume(readAccountProperty("prenume"))
                .withTelefon(readAccountProperty("telefon")).withEmail(readAccountProperty("email")).withParola(readAccountProperty("parola"))
                .withConfirmParola(readAccountProperty("confirmareparola")).build();
        return cont;
    }

}
