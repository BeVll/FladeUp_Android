package com.bevl.fladeup.dto.User;

public class UserModelDTO {
        private int id;
        private String firstname;
        private String lastname;
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstname;
        }

        public void setFirstName(String firstName) {
            this.firstname = firstName;
        }

        public String getLastName() {
            return lastname;
        }

        public void setLastName(String lastName) {
            this.lastname = lastName;
        }
}
