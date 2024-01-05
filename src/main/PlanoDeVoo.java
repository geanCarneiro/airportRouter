package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlanoDeVoo {

    private ArrayList<Voo> voos = new ArrayList<>();
    private ArrayList<Aeroporto> aeroportos = new ArrayList<>();

    public boolean isMaior(int[] maior, int[] menor){
        if(maior[0] == menor[0])
            return maior[1] > maior[1];
        else
            return maior[0] > menor[0];
    }

    public List<Voo> getMenorCaminho(Aeroporto origem, Aeroporto destino) {
        
        
        List<Aeroporto> naoVisitado = new ArrayList<>();

        List<Voo> menorCaminho = new ArrayList<>();

        Aeroporto atual;
        Aeroporto vizinho;
        Aeroporto aeroportoCaminho;

        this.aeroportos.forEach(aeroporto -> {
            if (aeroporto == origem) {
                aeroporto.setDistancia(0);
            } else {
                aeroporto.setDistancia(Integer.MAX_VALUE);
            }

            naoVisitado.add(aeroporto);
        });

        Collections.sort(naoVisitado);

        while (!naoVisitado.isEmpty()) {
            
            atual = naoVisitado.get(0);

            for (Voo voo : getVooComOrigem(atual)) {

                vizinho = voo.getAeroportoChegada();

                if (!vizinho.isVisitado()) {

                    int distanciaPossivel = atual.getDistancia() + voo.getTempoDeVooInMinutes();
                    Voo vooChegada = atual.getVia();

                    if (vizinho.getDistancia() > distanciaPossivel
                            && (vooChegada == null || voo.getHoraDeSaida().isAfter(vooChegada.getHoraDeChegada()) )) {

                            vizinho.setDistancia(distanciaPossivel);
                            vizinho.setVia(voo);

                            if (vizinho == destino) {

                                menorCaminho.clear();
                                aeroportoCaminho = vizinho;
                                while (aeroportoCaminho.getVia() != null) {
                                    menorCaminho.add(0, aeroportoCaminho.getVia());
                                    aeroportoCaminho = aeroportoCaminho.getVia().getAeroportoSaida();
                                }
                            }
                        
                    }

                }

            }

            atual.setVisitado(true);
            naoVisitado.remove(atual);
            Collections.sort(naoVisitado);

        }
        this.aeroportos.forEach(a -> {
            a.setVisitado(false);
        });
        return menorCaminho;

    }

    public List<Voo> getVooComOrigem(Aeroporto aeroporto) {
        List<Voo> out = new ArrayList<>();

        for (Voo voo : this.voos) {
            if (voo.getAeroportoSaida() == aeroporto) {
                out.add(voo);
            }
        }

        return out;
    }

    public Aeroporto addAeroporto(Aeroporto aeroporto) {
        int index = this.aeroportos.indexOf(aeroporto);

        if (index < 0) {
            this.aeroportos.add(aeroporto);
            return aeroporto;
        } else {
            return this.aeroportos.get(index);
        }

    }

    public void addVoo(String diasDisponives, String codVoo, String codAviao, String horaDeSaida_aeroportoSaida,
            String horaDeChegada_aeroportoChegada) {

        String icaoSaida = horaDeSaida_aeroportoSaida.substring(0, 4);
        String nomeSaida = Main.ICAO_DICIO.getProperty(icaoSaida, "");
        String horaDeSaida = horaDeSaida_aeroportoSaida.substring(4);

        String icaoChegada = horaDeChegada_aeroportoChegada.substring(0, 4);
        String nomeChegada = Main.ICAO_DICIO.getProperty(icaoChegada, "");
        String horaDeChegada = horaDeChegada_aeroportoChegada.substring(4);

        addVoo(new Voo(diasDisponives, codVoo, codAviao, horaDeSaida, addAeroporto(new Aeroporto(icaoSaida, nomeSaida)), horaDeChegada, addAeroporto(new Aeroporto(icaoChegada, nomeChegada))));

    }

    public void addVoo(String diasDisponives, String codVoo, String codAviao, String horaDeSaida,
            String aeroportoSaida, String horaDeChegada, String aeroportoChegada) {

        addVoo(new Voo(diasDisponives, codVoo, codAviao, horaDeSaida, addAeroporto(new Aeroporto(aeroportoSaida)), horaDeChegada, addAeroporto(new Aeroporto(aeroportoChegada))));

    }

    public Aeroporto getAeroporto(String str) {
        int indexBegin = str.indexOf("(");
        int indexEnd = str.indexOf(")");
        int index;
        if (indexBegin > -1 && indexEnd > 0) {
            String icao = str.substring(indexBegin + 1, indexEnd).trim();
            String nome = str.substring(indexEnd + 1).trim();
            index = this.aeroportos.indexOf(new Aeroporto(icao, nome));
        } else {
            index = this.aeroportos.indexOf(new Aeroporto(str));
        }

        if (index == -1) {
            return null;
        } else {
            return this.aeroportos.get(index);
        }
    }

    public List<Aeroporto> getAllAeroportosWith(String str) {

        List<Aeroporto> out = new ArrayList();

        this.aeroportos.forEach(a -> {
            if (a.getIcao().contains(str) || a.getName().contains(str)) {
                out.add(a);
            }
        });

        return out;

    }

    public void addVoo(Voo voo) {

        this.voos.add(voo);

    }

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public List<Aeroporto> getVizinhosDe(Aeroporto aeroporto) {
        List<Aeroporto> out = new ArrayList<>();

        this.voos.forEach((voo) -> {
            if (voo.getAeroportoSaida() == aeroporto) {
                out.add(voo.getAeroportoChegada());
            }
        });

        return out;
    }

    public List<Voo> getVoosComDestinoA(Aeroporto aeroporto) {
        List<Voo> out = new ArrayList<>();

        this.voos.forEach((voo) -> {
            if (voo.getAeroportoChegada() == aeroporto) {
                out.add(voo);
            }
        });

        return out;
    }

    public List<Voo> getVoo(Aeroporto origem, Aeroporto destino) {

        List<Voo> out = new ArrayList<>();

        for (Voo voo : this.voos) {
            if (voo.getAeroportoSaida().equals(origem) && voo.getAeroportoChegada().equals(destino)) {
                out.add(voo);
            }
        }

        return out;
    }

}
