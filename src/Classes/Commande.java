package Classes;
import java.util.ArrayList;
import java.util.Date;

public class Commande {
    private int id;
    private Date date;
    private String address;
    private PaiementMode mode;
    private Client client;
    private ArrayList<Line> lines=new ArrayList<Line>();

    public Commande() {
    }

    public Commande(int id, Date date, String address) {
        this.id = id;
        this.date = date;
        this.address = address;
        this.mode=PaiementMode.ONLINE;
    }

    public Commande(int id, Date date, String address, PaiementMode mode, Client client) {
        this.id = id;
        this.date = date;
        this.address = address;
        this.mode=client.isLoyal()?mode:PaiementMode.ONLINE;
        this.client = client;
    }
    public Commande(int id, Date date, String address, PaiementMode mode, Client client,ArrayList<Line> lines) {
        this.id = id;
        this.date = date;
        this.address = address;
        this.mode=client.isLoyal()?mode:PaiementMode.ONLINE;
        this.client = client;
        this.lines.addAll(lines);
    }
    public void addLine(Line line){
        this.lines.add(line);
    }
    public void addLines(ArrayList<Line> lines){
        this.lines.addAll(lines);
    }

    @Override
    public String toString() {
        return id+"\t"+date.toString()+"\t"+address+"\t"+mode.toString()+"\t"+getTotal()+"\t"+client.toString();
    }

    private int getTotal() {
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PaiementMode getMode() {
        return mode;
    }

    public void setMode(PaiementMode mode) {
        this.mode = mode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
}
