package org.mcupdater.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Instance {
	private String mcversion;
	private String revision;
	private String hash = "";
	private List<FileInfo> instanceFiles = new ArrayList<>();
	private List<FileInfo> jarMods = new ArrayList<>();
	private Map<String, Boolean> optionalMods = new HashMap<>();
	
	public List<FileInfo> getInstanceFiles() {
		return instanceFiles;
	}
	
	public void setInstanceFiles(List<FileInfo> instanceFiles) {
		this.instanceFiles = instanceFiles;
	}
	
	public Map<String, Boolean> getOptionalMods() {
		return this.optionalMods;
	}
	
	public Boolean getModStatus(String key) {
		return this.optionalMods.get(key);
	}
	
	public void setModStatus(String key, Boolean value) {
		this.optionalMods.put(key, value);
	}
	
	public String getMCVersion() {
		return mcversion;
	}
	
	public void setMCVersion(String mcversion) {
		this.mcversion = mcversion;
	}
	
	public String getRevision() {
		return revision;
	}
	
	public void setRevision(String revision) {
		this.revision = revision;
	}
	
	public List<FileInfo> getJarMods() {
		return jarMods;
	}
	
	public void setJarMods(List<FileInfo> jarMods) {
		this.jarMods = jarMods;
	}
	
	public FileInfo findJarMod(String id) {
		for (FileInfo entry : this.jarMods) {
			if (entry.getModId().equals(id)) {
				return entry;
			}
		}
		return null;
	}

	public void addJarMod(String id, String md5) {
		FileInfo entry = new FileInfo();
		entry.setModId(id);
		entry.setMD5(md5);
		this.jarMods.add(entry);
	}
	
	public void addMod(String id, String md5, String filename) {
		FileInfo entry = new FileInfo();
		entry.setModId(id);
		entry.setMD5(md5);
		entry.setFilename(filename);
		this.instanceFiles.add(entry);
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
}