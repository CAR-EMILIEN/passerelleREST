package com.example.services;

import org.springframework.stereotype.Service;
import org.apache.commons.net.ftp.*;

import com.example.model.Host;


@Service
public class Passerelle {
	
	
	
	public String ls() {
		
		return "toto est content";
	}

	public String parseCommand(String host, String cmd) {
		
		if (!ClientFTP.existCMD(cmd))
			return "error cmd";
		
		Host h = new Host(host);
		ClientFTP ftp = new ClientFTP(h.getAdresse(),h.getPort(),h.getName(),h.getPass());
		
			
		return ftp.cmd(cmd);
	}

}
