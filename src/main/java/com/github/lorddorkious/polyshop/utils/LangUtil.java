package com.github.lorddorkious.polyshop.utils;

import com.github.lorddorkious.polyshop.Main;
import com.github.lorddorkious.polyshop.constants.Misc;
import org.bukkit.configuration.ConfigurationSection;

import static com.github.lorddorkious.polyshop.constants.Locations.F_LANG;

public class LangUtil {
    public static Dynafig dLang;

    public static void setupLangYML(String lang){
        {
            dLang.setup("en-US",F_LANG);

            dLang.get().options().copyDefaults(true);
            dLang.save();
        }

        if(lang == null) lang = "en-US";

        if (!lang.equals("en-US")){
            ConfigurationSection conf = dLang.get().getConfigurationSection("");

            dLang.setup(lang,F_LANG);

            for (String s : conf.getKeys(true)){
                if (!dLang.get().contains(s)){
                    Main.console.sendMessage(Misc.POLYSHOP_PREFIX + "String Key " + s + " added");
                    dLang.get().addDefault(s, conf.get(s));
                }
            }
        } else {
            dLang.setup(lang, F_LANG);
        }

        dLang.get().options().copyDefaults(true);
        dLang.save();

    }
}
