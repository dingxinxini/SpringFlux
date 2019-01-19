package cn;


public class Role {

  private Integer id;
  private String rolename;

  public Role(Integer id, String rolename) {
    this.id = id;
    this.rolename = rolename;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }

}
