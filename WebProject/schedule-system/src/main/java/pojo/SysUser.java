package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor //全参构造器
@NoArgsConstructor  //无参构造器
@Data               //getter setter hashcode equals toString
//实现序列化接口
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;
}
