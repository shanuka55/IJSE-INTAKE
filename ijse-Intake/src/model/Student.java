package model;


public class Student {
        private String id;
        private String name;
        private String mail;
        private String contact;
        private String address;
        private String nic;

        public Student(String id, String name, String mail, String contact, String address, String nic) {
                this.id = id;
                this.name = name;
                this.mail = mail;
                this.contact = contact;
                this.address = address;
                this.nic = nic;
        }

        public Student() {
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getMail() {
                return mail;
        }

        public void setMail(String mail) {
                this.mail = mail;
        }

        public String getContact() {
                return contact;
        }

        public void setContact(String contact) {
                this.contact = contact;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getNic() {
                return nic;
        }

        public void setNic(String nic) {
                this.nic = nic;
        }

        @Override
        public String toString() {
                return "Student{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", mail='" + mail + '\'' +
                        ", contact='" + contact + '\'' +
                        ", address='" + address + '\'' +
                        ", nic='" + nic + '\'' +
                        '}';
        }
}

