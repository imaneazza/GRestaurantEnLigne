package Classes;

public class Client {
    private int code;
    private String tel;
    private String address;
    private boolean loyal;
    private int compteId;

    public Client(int code,String tel,String address,boolean loyal,int compteId){
        this.code=code;
        this.tel=tel;
        this.address=address;
        this.loyal=loyal;
        this.compteId=compteId;
    }

    public Client() {
    }

    public Client(int code, String tel, String address, boolean loyal) {

        this.code = code;
        this.tel = tel;
        this.address = address;
        this.loyal = loyal;
    }

    @Override
    public String toString() {
        return code+"\t"+tel+"\t"+address+"\tloyalty: "+loyal;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }

    public int getCompteId() {
        return compteId;
    }

    public void setCompteId(int compteId) {
        this.compteId = compteId;
    }
}
