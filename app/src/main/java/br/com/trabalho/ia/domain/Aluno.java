package br.com.trabalho.ia.domain;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import br.com.trabalho.ia.repository.IAlunoRepository;

@Entity(tableName = "aluno")
public class Aluno implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private Integer audicao;
    private Integer repeticao;
    private Integer visao;
    private Integer ajuda;
    private Integer auxilioEscolar;
    private Integer consumoTempo;
    private Integer espacoEstudo;
    private Integer materialDidatico;
    private Integer tempoEstudo;
    private Integer aprenderMais;
    private Integer concorso;
    private Integer melhorarNota;
    private Double mediaAutodidata;
    private Double mediaExtraCurricular;
    private Double mediaFamilia;
    private Double mediaReforco;

    @Ignore
    private IAlunoRepository alunoRepository;

    public void insert(){
        if (alunoRepository != null){
            alunoRepository.insert(this);
        }
    }
    public void setAlunoRepository(IAlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAudicao() {
        return audicao;
    }

    public void setAudicao(Integer audicao) {
        this.audicao = audicao;
    }

    public Integer getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Integer repeticao) {
        this.repeticao = repeticao;
    }

    public Integer getVisao() {
        return visao;
    }

    public void setVisao(Integer visao) {
        this.visao = visao;
    }

    public Integer getAjuda() {
        return ajuda;
    }

    public void setAjuda(Integer ajuda) {
        this.ajuda = ajuda;
    }

    public Integer getAuxilioEscolar() {
        return auxilioEscolar;
    }

    public void setAuxilioEscolar(Integer auxilioEscolar) {
        this.auxilioEscolar = auxilioEscolar;
    }

    public Integer getConsumoTempo() {
        return consumoTempo;
    }

    public void setConsumoTempo(Integer consumoTempo) {
        this.consumoTempo = consumoTempo;
    }

    public Integer getEspacoEstudo() {
        return espacoEstudo;
    }

    public void setEspacoEstudo(Integer espacoEstudo) {
        this.espacoEstudo = espacoEstudo;
    }

    public Integer getMaterialDidatico() {
        return materialDidatico;
    }

    public void setMaterialDidatico(Integer materialDidatico) {
        this.materialDidatico = materialDidatico;
    }

    public Integer getTempoEstudo() {
        return tempoEstudo;
    }

    public void setTempoEstudo(Integer tempoEstudo) {
        this.tempoEstudo = tempoEstudo;
    }

    public Integer getAprenderMais() {
        return aprenderMais;
    }

    public void setAprenderMais(Integer aprenderMais) {
        this.aprenderMais = aprenderMais;
    }

    public Integer getConcorso() {
        return concorso;
    }

    public void setConcorso(Integer concorso) {
        this.concorso = concorso;
    }

    public Integer getMelhorarNota() {
        return melhorarNota;
    }

    public void setMelhorarNota(Integer melhorarNota) {
        this.melhorarNota = melhorarNota;
    }

    public Double getMediaAutodidata() {
        return mediaAutodidata;
    }

    public void setMediaAutodidata(Double mediaAutodidata) {
        this.mediaAutodidata = mediaAutodidata;
    }

    public Double getMediaExtraCurricular() {
        return mediaExtraCurricular;
    }

    public void setMediaExtraCurricular(Double mediaExtraCurricular) {
        this.mediaExtraCurricular = mediaExtraCurricular;
    }

    public Double getMediaFamilia() {
        return mediaFamilia;
    }

    public void setMediaFamilia(Double mediaFamilia) {
        this.mediaFamilia = mediaFamilia;
    }

    public Double getMediaReforco() {
        return mediaReforco;
    }

    public void setMediaReforco(Double mediaReforco) {
        this.mediaReforco = mediaReforco;
    }
}
