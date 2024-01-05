package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import main.jFrame.JFramePrincipal;

public class Main {
    
    private static final File ARQ_DICIO = new File(ClassLoader.getSystemResource("").getPath(), "icaosDicio.properties");
    public static final Properties ICAO_DICIO = new Properties();
    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	public static void main(String[] args) {
            
            if(ARQ_DICIO.exists())
            	carregarDicionario(ARQ_DICIO);
            else
                System.err.println("Dicionario inexistente");
            
            new JFramePrincipal();

	}

    private static void carregarDicionario(File dicio) {
        
        try {
        	
        	FileReader reader = new FileReader(dicio);
        	ICAO_DICIO.load(reader);
			reader.close();
			
        	
        } catch (IOException e) {
			// TODO Auto-generated catch block
        	System.err.println("Erro ao carregar ou salvar dicionario");
			e.printStackTrace();
		}
       
        
        
    }

}
