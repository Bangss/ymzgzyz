create schema ymzgzyz collate gb2312_chinese_ci;

create table active_inf
(
	active_id int auto_increment
		primary key ,
	active_user_role int not null,
	active_user_id int not null,
	active_company varchar(50) not null,
	active_boss varchar(50) not null,
	active_tel varchar(50) not null,
	active_qq int not null,
	active_email varchar(50) not null,
	active_wechat varchar(50) not null,
	active_states int not null,
	acvite_start_time date not null,
	active_end_time date not null,
	active_s_time date not null,
	active_e_time date not null,
	active_image varchar(50) null,
	active_title char(20) not null,
	active_content varchar(200) not null,
	active_num int null
);

create table active_sign
(
	up_id int auto_increment
		primary key,
	active_id int not null,
	v_id int not null,
	up_real_name varchar(50) not null,
	up_tel varchar(50) null,
	up_wechat varchar(50) null,
	up_email varchar(50) not null,
	up_time date not null
);

create table admin
(
	admin_id int auto_increment
		primary key,
	admin_role int not null,
	admin_name varchar(50) not null,
	admin_pwd varchar(50) not null,
	admin_tel varchar(50) null
);

create table c_inf
(
	c_id int auto_increment
		primary key,
	c_name varchar(50) not null,
	c_pwd varchar(50) not null,
	c_image varchar(50) null,
	c_real_name varchar(50) not null,
	c_tel varchar(50) not null,
	c_wechat varchar(50) null,
	c_email varchar(50) null,
	c_address varchar(50) not null,
	c_place varchar(50) not null,
	c_born date not null,
	c_level varchar(50) not null,
	c_reg_time date not null,
	c_last_time date null,
	c_parent_name1 varchar(50) not null,
	c_parent_tel1 varchar(50) not null,
	c_parent_name2 varchar(50) null,
	c_parent_tel2 varchar(50) null
);

create table login
(
	id int not null,
	role int not null,
	login_time date not null
);

create table msg_inf
(
	m_id int auto_increment
		primary key,
	m_user_role int not null,
	m_user_id int not null,
	m_role int not null,
	m_states int not null,
	m_start_time date not null,
	m_end_time date not null,
	m_image varchar(50) null,
	m_title char(20) not null,
	m_content varchar(200) not null
);

create table msg_read
(
	r_id int not null
		primary key,
	m_id int not null,
	r_user_role int not null,
	r_time date not null,
	constraint msg_read_msg_inf_m_id_fk
		foreign key (m_id) references msg_inf (m_id)
);

create table msg_talk
(
	t_id int not null
		primary key,
	m_id int not null,
	t_c_role int null,
	t_c_id int not null,
	t_c_name varchar(50) null,
	t_r_role int null,
	t_r_id int null,
	t_r_name varchar(50) null,
	t_time date not null,
	t_content char(20) not null,
	constraint msg_talk_msg_inf_m_id_fk
		foreign key (m_id) references msg_inf (m_id)
);

create table v_inf
(
	v_id int auto_increment
		primary key,
	v_name varchar(50) not null,
	v_pwd varchar(50) not null,
	v_image varchar(50) null,
	v_real_name varchar(50) not null,
	v_tel varchar(50) not null,
	v_wechat varchar(50) null,
	v_email varchar(50) not null,
	v_school varchar(50) not null,
	v_address varchar(50) not null,
	v_place varchar(50) not null,
	v_born date not null,
	v_reg_time date not null,
	v_last_time date null,
	v_card varchar(50) not null,
	v_organization varchar(50) not null,
	v_m_power int not null,
	v_view_power int not null
);

create table view_father
(
	father_id int auto_increment
		primary key,
	father_name varchar(50) not null
);

create table view_inf
(
	view_id int auto_increment
		primary key,
	view_user_role int not null,
	view_user_id int not null,
	father_id int not null,
	su_id int not null,
	view_start_time date not null,
	view_title char(20) not null,
	view_path varchar(200) null,
	constraint view_inf_view_father_father_id_fk
		foreign key (father_id) references view_father (father_id)
);

create table view_read
(
	vr_id int auto_increment
		primary key,
	view_id int null,
	vr_user_role int not null,
	vr_user_id int not null,
	r_time date not null,
	constraint view_read_view_inf_view_id_fk
		foreign key (view_id) references view_inf (view_id)
);

create table view_son
(
	su_id int auto_increment
		primary key,
	father_id int not null,
	su_name varchar(50) not null,
	constraint view_son_view_father_father_id_fk
		foreign key (father_id) references view_father (father_id)
);

create table view_talk
(
	vt_id int auto_increment
		primary key,
	vr_id int not null,
	vt_c_role int not null,
	vt_c_name varchar(50) not null,
	vt_r_role int not null,
	vt_r_id int not null,
	vt_r_name varchar(50) null,
	t_time date not null,
	t_content char(20) not null,
	constraint view_talk_view_read_vr_id_fk
		foreign key (vr_id) references view_read (vr_id)
);

