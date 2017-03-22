package uk.co.news.valma.service;

import java.util.Map;

public class MethodeServiceStub implements MethodeService {
	private Map<String, String> heads;
	
	public MethodeServiceStub(Map<String, String> heads) {
		this.heads = heads;
	}
	
	@Override
	public String getHeadline(String uuid, String channel) {
		return heads.get(uuid);
	}

}
