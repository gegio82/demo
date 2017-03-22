package uk.co.news.valma.service;

import java.util.Map;

public class DataModelServiceStub implements DataModelService {

	private Map<String, String> heads;
	
	public DataModelServiceStub(Map<String, String> heads) {
		this.heads = heads;
	}
	
	@Override
	public String getTitle(String uuid) {
		return heads.get(uuid);
	}

}
