package mx.com.cdp.consumirws;

public class InitValues {
    private String ID;
    private String CPY_CODE;
    private String NODE_TYPE;
    private String NODE_CODE;
    private String VAE_ID;
    private String SAM_ID;
    private String SAM_TYPE;
    private String SAM_UID;
    private String LINE;
    private String STATION;
    private String TRAY;
    private String ECO;

    public InitValues(String ID, String CPY_CODE, String NODE_TYPE, String NODE_CODE, String VAE_ID, String SAM_ID, String SAM_TYPE, String SAM_UID, String LINE, String STATION, String TRAY, String ECO) {
        this.ID = ID;
        this.CPY_CODE = CPY_CODE;
        this.NODE_TYPE = NODE_TYPE;
        this.NODE_CODE = NODE_CODE;
        this.VAE_ID = VAE_ID;
        this.SAM_ID = SAM_ID;
        this.SAM_TYPE = SAM_TYPE;
        this.SAM_UID = SAM_UID;
        this.LINE = LINE;
        this.STATION = STATION;
        this.TRAY = TRAY;
        this.ECO = ECO;
    }



    public String getID() {
        return ID;
    }

    public String getCPY_CODE() {
        return CPY_CODE;
    }

    public String getNODE_TYPE() {
        return NODE_TYPE;
    }

    public String getNODE_CODE() {
        return NODE_CODE;
    }

    public String getVAE_ID() {
        return VAE_ID;
    }

    public String getSAM_ID() {
        return SAM_ID;
    }

    public String getSAM_TYPE() {
        return SAM_TYPE;
    }

    public String getSAM_UID() {
        return SAM_UID;
    }

    public String getLINE() {
        return LINE;
    }

    public String getSTATION() {
        return STATION;
    }

    public String getTRAY() {
        return TRAY;
    }

    public String getECO() {
        return ECO;
    }
}
