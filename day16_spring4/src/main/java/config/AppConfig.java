package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // mandatory to tell spring container follwoeing
//is java config class,as a replacemnet of xml config file
@ComponentScan(basePackages = { "dependent,dependency" })
public class AppConfig {
//Later we will add @BEAN annotated methods (equivalent to <Bean id class..>:in SPRING SECURITY")
}
