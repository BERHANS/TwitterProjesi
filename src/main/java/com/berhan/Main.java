package com.berhan;

import com.berhan.controller.CommentController;
import com.berhan.controller.RetweetController;
import com.berhan.controller.TwitController;
import com.berhan.controller.UserController;
import com.berhan.repository.entity.Comment;
import com.berhan.repository.entity.Twit;
import com.berhan.repository.entity.User;
import com.berhan.utility.HibernateUtility;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.mapping.TypeDef;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


   menu();




    }


        private static void gorselMenu(){

            System.out.println("******************************");
            System.out.println("****TWİTTER'A HOŞ GELDİNİZ****");
            System.out.println("******************************");
            System.out.println();
            System.out.println("1- Kayıt Ol");
            System.out.println("2- Giriş Yap");
            System.out.println("0- Kapat");

        }
        private static void menu(){
        boolean cikis = false;

        do{
            gorselMenu();
            System.out.println("Seçim Yapınız");
            int secim = new Scanner(System.in).nextInt();

            switch (secim){
                case 1:
                    UserController userController =new UserController() ;
                    userController.registerUser();break;
                case 2:registerMenu();break;
                case 0: cikis = true; break;
                default:
                    System.out.println("İşlem Başarısız");break;
            }
        }while (!cikis);

        }

        public static void registerMenu() {
        Long kullaniciId = findMyId();
        TwitController twitController = new TwitController();
            boolean kontrol = false;
            do {
                System.out.println("************");
                System.out.println("1- Tweet At");
                System.out.println("2- Retweet Yap");
                System.out.println("3- Comment Yap");
                System.out.println("4- Commentları Gör");
                System.out.println("0- Cikis Yap");
                System.out.print("Seçim Yapınız: ");
                int secim = new Scanner(System.in).nextInt();

                switch (secim) {
                    case 1: twitController.tweetAt(kullaniciId);
                    break;
                    case 2: {
                        for (Twit twit : twitController.findAll()) {
                            System.out.println(twit);
                        }
                        System.out.println("ReTweet Yapmak istediğiniz Id'yi seç: ");
                        Long Id = new Scanner(System.in).nextLong();
                        RetweetController retweetController = new RetweetController();
                        retweetController.reTweetYap(Id, kullaniciId);break;
                    }
                    case 3: {
                        for (Twit twit : twitController.findAll()) {
                            System.out.println(twit);
                        }
                        System.out.println("Comment Yapmak istediğiniz Id'yi seç: ");
                        Long Id = new Scanner(System.in).nextLong();
                        CommentController commentController = new CommentController();
                        commentController.commentYap(Id, kullaniciId);break;

                    }
                    case 4: {yorumlarGor().forEach(x->{
                        System.out.println(x.toString());
                    });break;}
                    case 0:
                        kontrol= true;
                        break;
                    default:
                        System.out.println("İşlem Gerçekleştirilemedi");break;
                }
            }while (!kontrol);
        }
            public static Long findMyId() {
                UserController userController1 = new UserController();
                System.out.println("Kullanici Adinizi Giriniz");
                String kullaniciAdi = new Scanner(System.in).nextLine();
                return  userController1.findByColumnNameAndValue("username", kullaniciAdi).get(0).getId();
            }

            public static List<Comment> yorumlarGor(){
              TwitController twitController = new TwitController();
                EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
                String sql = "SELECT * FROM tblcomment  WHERE twitid= :x";
                TypedQuery<Comment> query = (TypedQuery<Comment>) entityManager.createNativeQuery(sql, Comment.class);
                for (Twit twit : twitController.findAll()) {
                    System.out.println(twit);
                }
                System.out.println("Seçmek istediğiniz Tweet");
                Long id = new Scanner(System.in).nextLong();
                query.setParameter("x",id);
                return query.getResultList();

                }

        }

