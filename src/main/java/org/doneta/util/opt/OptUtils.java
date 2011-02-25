package org.doneta.util.opt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OptsUtil 参数工具类
 * @author Hypnusds
 */
public class OptUtils {

	private Map<String, Opt> parameter;
	private Map<String, Integer> option;
	private List<String> tempOpt;
	private List<Character> opt;

	public OptUtils(Map<String, Opt> parameter) {
		this.parameter = parameter;
	}

	public Map<String, Integer> init(String[] args) {
		boolean flag = true;
		tempOpt = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("-")) {
				tempOpt.add(args[i]);
				flag = false;
			}
		}
		if (flag)
			return null;
		opt = new ArrayList<Character>();
		for (int i = 0; i < tempOpt.size(); i++) {
			String temp = tempOpt.get(i).substring(1);
			for (int j = 0; j < temp.length(); j++) {
				opt.add(temp.charAt(j));
			}
		}
		option = new HashMap<String, Integer>();
		for (String modeName : parameter.keySet()) {
			Opt opts = parameter.get(modeName);
			for (int i = 0; i < opt.size(); i++) {
				Integer val = opts.getVal(opt.get(i));
				if (val != null) {
					option.put(modeName, val);
					break;
				}
			}
		}
		return this.option;
	}

}
