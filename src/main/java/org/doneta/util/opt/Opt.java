package org.doneta.util.opt;

import java.util.HashMap;
import java.util.Map;

/**
 * Opts 参数实体
 * @author Hypnusds
 */
public class Opt {
	
	private Map<Character, Integer> opts;
	
	public Opt(){
		opts = new HashMap<Character, Integer>();
	}
	
	public Opt(Character name, Integer val){
		this();
		addOpt(name, val);
	}
	
	public void addOpt(Character name, Integer val){
		opts.put(name, val);
	}
	
	public Integer getVal(Character name){
		return opts.get(name);
	}
	
}
