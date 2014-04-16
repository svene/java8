package org.svenehrke.checkout.java8.misc;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;
import java.util.logging.Logger;

public class ScriptEngineFactories {

	private static Logger log = Logger.getLogger(ScriptEngineFactories.class.getName());

	public static void main(String[] args) {
		List<ScriptEngineFactory> factories = new ScriptEngineManager().getEngineFactories();
		for (ScriptEngineFactory factory : factories) {
			log.info("lang name: " + factory.getLanguageName());
			log.info("engine name: " + factory.getEngineName());
			log.info(factory.getNames().toString());
		}
	}
}