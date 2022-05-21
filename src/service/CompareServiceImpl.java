package service;

import exception.DSException;

public class CompareServiceImpl implements CompareService {

	@Override
	public int compare(Integer value1, Integer value2) {
		checkInputParameters(value1, value2);
		int result = value1.compareTo(value2);
		return result == 0 ? 0 : result > 0 ? 1 : -1;
	}
	
	private void checkInputParameters(Integer arg1, Integer arg2) {
		if(arg1 == null || arg2 == null) {
			throw new DSException("Arguments cannot be null!");	
		}
	}

}
