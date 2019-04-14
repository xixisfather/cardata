drop table if exists tb_staff_user;

/*==============================================================*/
/* Table: tb_staff_user                                          */
/*==============================================================*/
create table tb_staff_user
(
   id                   int not null auto_increment,
   user_name            varchar(20),
   user_password        varchar(50),
   full_name            varchar(10),
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;