package faith.elguadia.ds;

import org.apache.commons.io.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class config {
    public static final config CONFIG;
    static {
        config c;
        try {
            c = new config(
                    loadConfigFile("credentials")
            );
        } catch (IOException e) {
            c = null;
        }
        CONFIG = c;
    }

    private String botToken;


    public config(File cred){
        try {
            Yaml y = new Yaml();
            String credsFileStr = FileUtils.readFileToString(cred,"UTF-8");
            Map<String,Object> c = y.load(credsFileStr);
            c.keySet().forEach((String key)->c.putIfAbsent(key,""));

            botToken = (String) c.get("DiscordToken");
        } catch (IOException e){
            // Nothing
        }
    }

    private static File loadConfigFile(String name) throws IOException {
        String path = "./"+name+".yaml";
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            throw new FileNotFoundException("Could not find '" + path + "' file.");
        }
        return file;
    }
    public String getBotToken() {
        return botToken;
    }
}
