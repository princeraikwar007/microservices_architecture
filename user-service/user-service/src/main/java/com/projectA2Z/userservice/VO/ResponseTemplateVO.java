package com.projectA2Z.userservice.VO;

import com.projectA2Z.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private User user;
    private Department department;
    
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	public Department getDepartment() {
//		return department;
//	}
//	public void setDepartment(Department department) {
//		this.department = department;
//	}

    
}
