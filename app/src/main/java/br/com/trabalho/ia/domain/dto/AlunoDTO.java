package br.com.trabalho.ia.domain.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlunoDTO {
    @SerializedName("SEXO")
    @Expose
    private String sEXO;
    @SerializedName("IDADE")
    @Expose
    private String iDADE;
    @SerializedName("TAMANHO_FAMILIA")
    @Expose
    private String tAMANHOFAMILIA;
    @SerializedName("UNIAO_PAIS")
    @Expose
    private String uNIAOPAIS;
    @SerializedName("EDUCACAO_MAE")
    @Expose
    private String eDUCACAOMAE;
    @SerializedName("EDUCACAO_PAI")
    @Expose
    private String eDUCACAOPAI;
    @SerializedName("TRABALHO_MAE")
    @Expose
    private String tRABALHOMAE;
    @SerializedName("TRABALHO_PAI")
    @Expose
    private String tRABALHOPAI;
    @SerializedName("RAZAO_ESCOLHA_ESCOLA")
    @Expose
    private String rAZAOESCOLHAESCOLA;
    @SerializedName("GUARDA")
    @Expose
    private String gUARDA;
    @SerializedName("TEMPO_CHEGAR_ESCOLA")
    @Expose
    private String tEMPOCHEGARESCOLA;
    @SerializedName("HORAS_ESTUDADAS")
    @Expose
    private String hORASESTUDADAS;
    @SerializedName("REPETENTE")
    @Expose
    private String rEPETENTE;
    @SerializedName("AULAS_REFORCO")
    @Expose
    private String aULASREFORCO;
    @SerializedName("SUPORTE_FAMILIA")
    @Expose
    private String sUPORTEFAMILIA;
    @SerializedName("AULA_EXTRA_PAGA")
    @Expose
    private String aULAEXTRAPAGA;
    @SerializedName("ATIVIDADES_EXTRACURRICULARES")
    @Expose
    private String aTIVIDADESEXTRACURRICULARES;
    @SerializedName("RELACIONAMENTO")
    @Expose
    private String rELACIONAMENTO;
    @SerializedName("RELACIONAMENTO_FAMILIAR")
    @Expose
    private String rELACIONAMENTOFAMILIAR;
    @SerializedName("TEMPO_LIVRE")
    @Expose
    private String tEMPOLIVRE;
    @SerializedName("NUMERO_FALTAS")
    @Expose
    private String nUMEROFALTAS;
    @SerializedName("G1_PT")
    @Expose
    private String g1PT;
    @SerializedName("G2_PT")
    @Expose
    private String g2PT;
    @SerializedName("G3_PT")
    @Expose
    private String g3PT;
    @SerializedName("G1_MAT")
    @Expose
    private String g1MAT;
    @SerializedName("G2_MAT")
    @Expose
    private String g2MAT;
    @SerializedName("G3_MAT")
    @Expose
    private String g3MAT;

    public String getSEXO() {
        return sEXO;
    }

    public void setSEXO(String sEXO) {
        this.sEXO = sEXO;
    }

    public String getIDADE() {
        return iDADE;
    }

    public void setIDADE(String iDADE) {
        this.iDADE = iDADE;
    }

    public String getTAMANHOFAMILIA() {
        return tAMANHOFAMILIA;
    }

    public void setTAMANHOFAMILIA(String tAMANHOFAMILIA) {
        this.tAMANHOFAMILIA = tAMANHOFAMILIA;
    }

    public String getUNIAOPAIS() {
        return uNIAOPAIS;
    }

    public void setUNIAOPAIS(String uNIAOPAIS) {
        this.uNIAOPAIS = uNIAOPAIS;
    }

    public String getEDUCACAOMAE() {
        return eDUCACAOMAE;
    }

    public void setEDUCACAOMAE(String eDUCACAOMAE) {
        this.eDUCACAOMAE = eDUCACAOMAE;
    }

    public String getEDUCACAOPAI() {
        return eDUCACAOPAI;
    }

    public void setEDUCACAOPAI(String eDUCACAOPAI) {
        this.eDUCACAOPAI = eDUCACAOPAI;
    }

    public String getTRABALHOMAE() {
        return tRABALHOMAE;
    }

    public void setTRABALHOMAE(String tRABALHOMAE) {
        this.tRABALHOMAE = tRABALHOMAE;
    }

    public String getTRABALHOPAI() {
        return tRABALHOPAI;
    }

    public void setTRABALHOPAI(String tRABALHOPAI) {
        this.tRABALHOPAI = tRABALHOPAI;
    }

    public String getRAZAOESCOLHAESCOLA() {
        return rAZAOESCOLHAESCOLA;
    }

    public void setRAZAOESCOLHAESCOLA(String rAZAOESCOLHAESCOLA) {
        this.rAZAOESCOLHAESCOLA = rAZAOESCOLHAESCOLA;
    }

    public String getGUARDA() {
        return gUARDA;
    }

    public void setGUARDA(String gUARDA) {
        this.gUARDA = gUARDA;
    }

    public String getTEMPOCHEGARESCOLA() {
        return tEMPOCHEGARESCOLA;
    }

    public void setTEMPOCHEGARESCOLA(String tEMPOCHEGARESCOLA) {
        this.tEMPOCHEGARESCOLA = tEMPOCHEGARESCOLA;
    }

    public String getHORASESTUDADAS() {
        return hORASESTUDADAS;
    }

    public void setHORASESTUDADAS(String hORASESTUDADAS) {
        this.hORASESTUDADAS = hORASESTUDADAS;
    }

    public String getREPETENTE() {
        return rEPETENTE;
    }

    public void setREPETENTE(String rEPETENTE) {
        this.rEPETENTE = rEPETENTE;
    }

    public String getAULASREFORCO() {
        return aULASREFORCO;
    }

    public void setAULASREFORCO(String aULASREFORCO) {
        this.aULASREFORCO = aULASREFORCO;
    }

    public String getSUPORTEFAMILIA() {
        return sUPORTEFAMILIA;
    }

    public void setSUPORTEFAMILIA(String sUPORTEFAMILIA) {
        this.sUPORTEFAMILIA = sUPORTEFAMILIA;
    }

    public String getAULAEXTRAPAGA() {
        return aULAEXTRAPAGA;
    }

    public void setAULAEXTRAPAGA(String aULAEXTRAPAGA) {
        this.aULAEXTRAPAGA = aULAEXTRAPAGA;
    }

    public String getATIVIDADESEXTRACURRICULARES() {
        return aTIVIDADESEXTRACURRICULARES;
    }

    public void setATIVIDADESEXTRACURRICULARES(String aTIVIDADESEXTRACURRICULARES) {
        this.aTIVIDADESEXTRACURRICULARES = aTIVIDADESEXTRACURRICULARES;
    }

    public String getRELACIONAMENTO() {
        return rELACIONAMENTO;
    }

    public void setRELACIONAMENTO(String rELACIONAMENTO) {
        this.rELACIONAMENTO = rELACIONAMENTO;
    }

    public String getRELACIONAMENTOFAMILIAR() {
        return rELACIONAMENTOFAMILIAR;
    }

    public void setRELACIONAMENTOFAMILIAR(String rELACIONAMENTOFAMILIAR) {
        this.rELACIONAMENTOFAMILIAR = rELACIONAMENTOFAMILIAR;
    }

    public String getTEMPOLIVRE() {
        return tEMPOLIVRE;
    }

    public void setTEMPOLIVRE(String tEMPOLIVRE) {
        this.tEMPOLIVRE = tEMPOLIVRE;
    }

    public String getNUMEROFALTAS() {
        return nUMEROFALTAS;
    }

    public void setNUMEROFALTAS(String nUMEROFALTAS) {
        this.nUMEROFALTAS = nUMEROFALTAS;
    }

    public String getG1PT() {
        return g1PT;
    }

    public void setG1PT(String g1PT) {
        this.g1PT = g1PT;
    }

    public String getG2PT() {
        return g2PT;
    }

    public void setG2PT(String g2PT) {
        this.g2PT = g2PT;
    }

    public String getG3PT() {
        return g3PT;
    }

    public void setG3PT(String g3PT) {
        this.g3PT = g3PT;
    }

    public String getG1MAT() {
        return g1MAT;
    }

    public void setG1MAT(String g1MAT) {
        this.g1MAT = g1MAT;
    }

    public String getG2MAT() {
        return g2MAT;
    }

    public void setG2MAT(String g2MAT) {
        this.g2MAT = g2MAT;
    }

    public String getG3MAT() {
        return g3MAT;
    }

    public void setG3MAT(String g3MAT) {
        this.g3MAT = g3MAT;
    }
}
