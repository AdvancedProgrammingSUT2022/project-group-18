package model.techs;

public class Technology {
    private String name;
    private Integer cast;
    private String prerequisiteTechs;
    private String leadsToTechs;
    private String unlocks;
    String  type;

    public Technology(String name, Integer cast, String prerequisiteTechs, String leadsToTechs, String unlocks, String type, String note) {
        this.name = name;
        this.cast = cast;
        this.prerequisiteTechs = prerequisiteTechs;
        this.leadsToTechs = leadsToTechs;
        this.unlocks = unlocks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCast(Integer cast) {
        this.cast = cast;
    }

    public void setPrerequisiteTechs(String prerequisiteTechs) {
        this.prerequisiteTechs = prerequisiteTechs;
    }

    public void setLeadsToTechs(String leadsToTechs) {
        this.leadsToTechs = leadsToTechs;
    }

    public void setUnlocks(String unlocks) {
        this.unlocks = unlocks;
    }

    public String getName() {
        return name;
    }

    public Integer getCast() {
        return cast;
    }

    public String getPrerequisiteTechs() {
        return prerequisiteTechs;
    }

    public String getLeadsToTechs() {
        return leadsToTechs;
    }

    public String getUnlocks() {
        return unlocks;
    }
}
