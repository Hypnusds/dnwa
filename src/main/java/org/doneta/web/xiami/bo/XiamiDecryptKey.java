package org.doneta.web.xiami.bo;

import java.util.ArrayList;
import java.util.List;

import org.doneta.util.url.EscapeUtils;

public class XiamiDecryptKey {

	static class SingletonHolder {
		static XiamiDecryptKey instance = new XiamiDecryptKey();
	}

	public static XiamiDecryptKey getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * 解密方法
	 * 
	 * @param key
	 * @return String
	 */
	public String decryptKey(String key) {
		int _loc_2;
		String _loc_3;
		int _loc_4;
		int _loc_5;
		List<String> _loc_6;
		int _loc_7;
		String _loc_8;
		String _loc_9;
		int _loc_10;
		char tmp_loc_2 = key.charAt(0);
		_loc_2 = tmp_loc_2 - '0';
		_loc_3 = key.substring(1);
		_loc_4 = (int) Math.floor(_loc_3.length() / _loc_2);
		_loc_5 = _loc_3.length() % _loc_2;
		_loc_6 = new ArrayList<String>();
		_loc_7 = 0;
		while (_loc_7 < _loc_5) {
			int index = (_loc_4 + 1) * _loc_7;
			_loc_6.add(_loc_7, _loc_3.substring(index, _loc_4 + 1 + index));
			_loc_7++;
		}
		_loc_7 = _loc_5;
		while (_loc_7 < _loc_2) {
			int index = _loc_4 * (_loc_7 - _loc_5) + (_loc_4 + 1) * _loc_5;
			_loc_6.add(_loc_7, _loc_3.substring(index, _loc_4 + index));
			_loc_7++;
		}
		_loc_8 = "";
		_loc_7 = 0;
		while (_loc_7 < _loc_6.get(0).length()) {
			_loc_10 = 0;
			while (_loc_10 < _loc_6.size()) {
				String str = _loc_6.get(_loc_10);
				if (_loc_7 < str.length())
					_loc_8 = _loc_8 + _loc_6.get(_loc_10).charAt(_loc_7);
				_loc_10++;
			}
			_loc_7++;
		}
		_loc_8 = EscapeUtils.unescape(_loc_8);
		_loc_9 = "";
		_loc_7 = 0;
		while (_loc_7 < _loc_8.length()) {
			if (_loc_8.charAt(_loc_7) == '^') {
				_loc_9 = _loc_9 + "0";
				_loc_7++;
				continue;
			}
			_loc_9 = _loc_9 + _loc_8.charAt(_loc_7);
			_loc_7++;
		}
		_loc_9 = _loc_9.replace("+", " ");
		return _loc_9;
	}
	
	public static void main(String[] args) {
		String aaa = "4h%2Fxit34F62E5E9618mt3Ffi.%%833F1216253ptA%1an25%93%%%753643p%2.meFE22%52568_1.";
		System.out.println(XiamiDecryptKey.getInstance().decryptKey(aaa));
	}

}
