create database thuetoa;
use thuetoa;

create table loai_mat_bang (
    ma_lmb int primary key auto_increment,
    ten_lmb varchar(50)
);
insert into loai_mat_bang (ten_lmb) values ('Văn phòng chia sẻ'), ('Văn phòng trọn gói');

create table trang_thai (
    ma_tt int primary key auto_increment,
    ten_tt varchar(50)
);
insert into trang_thai (ten_tt) values ('Trống'), ('Hạ tầng'), ('Đầy đủ');

create table mat_bang (
    ma_mb varchar(9) primary key,
    dien_tich int,
    tang int,
    gia_tien int,
    ngay_bd date,
    ngay_kt date,
    ma_tt int,
    ma_lmb int,
    foreign key (ma_lmb) references loai_mat_bang(ma_lmb),
    foreign key (ma_tt) references trang_thai(ma_tt)
);

insert into mat_bang (ma_mb, dien_tich, tang, gia_tien, ngay_bd, ngay_kt, ma_tt, ma_lmb) values
('MB1-CY-CY', 30, 10, 6000000, '2024-09-09', '2025-06-30', 3, 2),
('MB2-MT-MT', 35, 6, 9100000, '2024-11-28', '2025-06-30', 2, 1),
('MB3-UT-UT', 40, 9, 6000000, '2024-11-3', '2025-06-30', 1, 2)

DELIMITER //
create procedure findAll()
begin
    select mat_bang.*, trang_thai.ten_tt, loai_mat_bang.ten_lmb
    from mat_bang
    join trang_thai on trang_thai.ma_tt = mat_bang.ma_tt
    join loai_mat_bang on loai_mat_bang.ma_lmb = mat_bang.ma_lmb
	order by mat_bang.dien_tich;
end //
DELIMITER ;

DELIMITER //
create procedure findAllSearch(
    in id_loai_trang_thai int
)
begin
select
    mat_bang.*,
    trang_thai.ten_tt,
    loai_mat_bang.ten_lmb
from
    mat_bang
        join
    trang_thai on trang_thai.ma_tt = mat_bang.ma_tt
        join
    loai_mat_bang on loai_mat_bang.ma_lmb = mat_bang.ma_lmb
where
    trang_thai.ma_tt = id_loai_trang_thai
order by
    mat_bang.dien_tich;
end //
DELIMITER ;

DELIMITER //
create procedure findAllLoaiMatBang()
begin
select *
from loai_mat_bang;
end //
DELIMITER ;


DELIMITER //
create procedure Search(
    in id_loai_mat_bang int
)
begin
select
    mat_bang.*,
    trang_thai.ten_tt,
    loai_mat_bang.ten_lmb
from
    mat_bang
        join
    trang_thai on trang_thai.ma_tt = mat_bang.ma_tt
        join
    loai_mat_bang on loai_mat_bang.ma_lmb = mat_bang.ma_lmb
where
    loai_mat_bang.ma_lmb = id_loai_mat_bang
order by
    mat_bang.dien_tich;
end //
DELIMITER ;
