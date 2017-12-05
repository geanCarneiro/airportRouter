package main;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import main.jFrame.JFramePrincipal;

public class Main {
    
    private static final File ARQ_DICIO = new File(ClassLoader.getSystemResource("").getPath(), "icaosDicio.txt");
    public static final HashMap<String, String> ICAO_DICIO = new HashMap<>();

	public static void main(String[] args) {
            
            if(ARQ_DICIO.exists())
                popularDicionario(FileManager.getLinesFromFile(ARQ_DICIO));
            else
                System.err.println("Dicionario inexistente");
            
            new JFramePrincipal();

	}

    private static void popularDicionario(List<String> lines) {
        
        ICAO_DICIO.clear();
        
        lines.forEach(l -> {
            String[] infos = l.split(";");
            
            ICAO_DICIO.put(infos[0], infos[1]);
        });
        
    }

}
