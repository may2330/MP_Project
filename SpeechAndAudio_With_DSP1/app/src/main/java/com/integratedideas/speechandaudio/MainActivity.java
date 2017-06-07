
package com.integratedideas.speechandaudio;


import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;


public class MainActivity extends TabActivity {

	ActionBar actionBar;
	public DBHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setCustomActionbar();
		final TabHost tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("",getResources().getDrawable(R.drawable.home))
			.setContent(new Intent(this,HomeActivity.class)));

		tabHost.addTab(tabHost.newTabSpec("tab2")
				.setIndicator("",getResources().getDrawable(R.drawable.check))
				.setContent(new Intent(this,SearchActivity.class)));
/*
		tabHost.addTab(tabHost.newTabSpec("tab3")
				.setIndicator("",getResources().getDrawable(R.drawable.search))
				.setContent(new Intent(this,FindMusic.class)));
*/
		makeDB();

	}

	public void makeDB(){
		String etDBName = "testDB";
		dbHelper = new DBHelper( MainActivity.this, etDBName, null, 1);
		dbHelper.testDB();

		boolean first = dbHelper.checkFirst();
		if(first) {
			insertScale("0","0");
			insertDB("다시 만난 세계", "소녀시대", "댄스","493","1290");
			insertDB("소녀시대", "소녀시대", "댄스","493","1290");
			insertDB("Baby Baby", "소녀시대", "댄스","440","1046");
			insertDB("Kissing You", "소녀시대", "댄스","440","1290");
			insertDB("Gee", "소녀시대", "댄스","587","1300");
			insertDB("소원을 말해봐", "소녀시대", "댄스","349","1046");
			insertDB("냉면", "소녀시대", "댄스","440","1046");
			insertDB("Oh!", "소녀시대", "댄스","493","1046");
			insertDB("Run Deil Run", "소녀시대", "댄스","493","1318");
			insertDB("훗", "소녀시대", "댄스","587","1174");
			insertDB("Twinkle", "소녀시대", "댄스","523","1300");
			insertDB("I Got A Boy", "소녀시대", "댄스","493","1174");
			insertDB("바보에게 바보가", "박명수", "발라드","195","698");
			insertDB("영웅주의", "강타", "발라드","219","740");
			insertDB("프로포즈", "강타", "발라드","225","740");
			insertDB("I love you", "김장훈", "발라드","223","740");
			insertDB("애수", "이문세", "발라드","211","740");
			insertDB("가려진 시간 사이로", "김범수", "발라드","223","740");
			insertDB("이등병의 편지", "김광석", "발라드","235","784");
			insertDB("여름밤의 꿈", "김건모", "발라드","234","784");
			insertDB("상록수", "강타", "발라드","240","784");
			insertDB("다시 사랑한다 말할까", "김동률", "발라드","223","784");
			insertDB("하소연", "김동률", "발라드","253","784");
			insertDB("이제서야", "김동률", "발라드","231","784");
			insertDB("왜", "김민종", "발라드","243","784");
			insertDB("아름다운 아픔", "김민종", "발라드","223","784");
			insertDB("사랑..그 흔한 말", "박효신", "발라드","253","784");
			insertDB("my love", "박효신", "발라드","243","784");
			insertDB("I Believe", "신승훈", "발라드","233","784");
			insertDB("사랑 Two", "윤도현밴드", "발라드","243","784");
			insertDB("너를 보내고", "윤도현밴드", "발라드","263","784");
			insertDB("먼훗날", "윤도현밴드", "발라드","213","784");
			insertDB("축복", "H.O.T", "발라드","223","784");
			insertDB("상처투성이", "먼데이키즈", "발라드","253","784");
			insertDB("사랑합니다", "Tim", "발라드","203","784");
			insertDB("취중진담", "전람회", "발라드","233","784");
			insertDB("I Love You", "포지션", "발라드","243","784");
			insertDB("삐에로", "이수", "발라드","253","784");
			insertDB("그대와 영원히", "김범수", "발라드","203","784");
			insertDB("I never let go", "동방신기", "발라드","266","830");
			insertDB("마지막사랑", "동방신기", "발라드","256","830");
			insertDB("슬픈언약식", "김정민", "발라드","246","830");
			insertDB("눈물잔", "박상민", "발라드","246","830");
			insertDB("외워두세요", "성시경", "발라드","266","830");
			insertDB("10月에 눈이 내리면", "성시경", "발라드","276","830");
			insertDB("그런날이 오겟죠", "신승훈", "발라드","236","830");
			insertDB("미소속에비친그대", "신승훈", "발라드","246","830");
			insertDB("너의 곁에서", "신화", "발라드","266","830");
			insertDB("사랑했어요", "SG워너비", "발라드","236","830");
			insertDB("살다가", "SG워너비", "발라드","276","830");
			insertDB("그리움을 사랑한 가시나무", "테이", "발라드","246","830");
			insertDB("나는나비", "윤도현밴드", "락","256","830");
			insertDB("사랑합니다", "김건모", "발라드","261","880");
			insertDB("Hug", "동방신기", "발라드","261","880");
			insertDB("마지막 약속", "김정민", "락","271","880");
			insertDB("떠나지마", "브라운아이즈", "발라드","261","880");
			insertDB("점점", "브라운아이즈", "발라드","271","880");
			insertDB("사랑했나봐", "윤도현밴드", "락","281","880");
			insertDB("신부에게", "유리상자", "발라드","261","880");
			insertDB("미소천사", "성시경", "발라드","251","880");
			insertDB("감기", "이기찬", "발라드","281","880");
			insertDB("결혼해줄래", "이승기", "발라드","271","880");
			insertDB("With me", "휘성", "발라드","261","880");
			insertDB("제발", "휘성", "발라드","291","880");
			insertDB("가시", "버즈", "발라드","251","880");
			insertDB("거짓말", "버즈", "발라드","281","880");
			insertDB("은인", "버즈", "발라드","261","880");
			insertDB("남자를 몰라", "버즈", "발라드","251","880");
			insertDB("나에게로 떠나는 여행", "버즈", "락","271","880");
			insertDB("My darling", "버즈", "발라드","241","880");
			insertDB("슬픈사슴", "부활", "락","271","880");
			insertDB("우리헤어지자", "이승기", "발라드","261","880");
			insertDB("추억은 사랑을 닮아", "박효신", "발라드","261","880");
			insertDB("미워도 다시한번", "바이브", "발라드","261","932");
			insertDB("사진을 보다가", "바이브", "발라드","261","932");
			insertDB("조언", "임창정", "발라드","251","932");
			insertDB("슬픈연가", "임창정", "발라드","241","932");
			insertDB("왜", "임창정", "발라드","271","932");
			insertDB("여우비", "임창정", "발라드","241","932");
			insertDB("그때가 그리워요", "임창정", "발라드","251","932");
			insertDB("바보", "박효신", "발라드","261","932");
			insertDB("세글자", "엠투엠", "발라드","261","932");
			insertDB("미안해", "야다", "발라드","287","988");
			insertDB("슬픈다짐", "야다", "발라드","277","988");
			insertDB("체념", "야다", "발라드","297","988");
			insertDB("하얀마음백구", "이수영", "발라드","287","988");
			insertDB("라라라", "이수영", "발라드","277","988");
			insertDB("입모양", "이승기", "발라드","279","988");
			insertDB("그런사람 또 없습니다", "이승철", "발라드","277","988");
			insertDB("소주한잔", "임창정", "발라드","267","988");
			insertDB("그때 또 다시", "임창정", "발라드","287","988");
			insertDB("아시나요", "조성모", "발라드","287","988");
			insertDB("안되나요", "휘성", "발라드","297","988");
			insertDB("Monologue", "버즈", "발라드","300","988");
			insertDB("겁쟁이", "버즈", "발라드","270","988");
			insertDB("벌써 일년", "브라운아이즈", "발라드","257","988");
			insertDB("Never Ending Story", "부활", "락","257","988");
			insertDB("백설공주를 사랑한 난쟁이", "더크로스", "발라드","297","988");
			insertDB("사랑비", "김태우", "발라드","297","988");
			insertDB("사랑한후에", "박효신", "발라드","250","988");
			insertDB("그립고 그립고 그립다", "케이윌", "발라드","257","988");
			insertDB("사랑이 술을 가르쳐", "이승기", "발라드","237","988");
			insertDB("희야", "부활", "락","277","1046");
			insertDB("잠시만 안녕", "MC the Max", "락","321","1046");
			insertDB("Memory", "MC the Max", "락","341","1046");
			insertDB("난", "MC the Max", "락","332","1046");
			insertDB("나를 보낸다", "MC the Max", "발라드","343","1046");
			insertDB("Love Actually", "MC the Max", "발라드","310","1046");
			insertDB("눈물은 모르게", "MC the Max", "발라드","323","1046");
			insertDB("삭제", "이승기", "발라드","311","1046");
			insertDB("당신을 위하여", "더크로스", "락","331","1046");
			insertDB("귀로", "나얼", "락","331","1046");
			insertDB("여전히 아름다운지", "토이", "발라드","301","1046");
			insertDB("너에게로", "부활", "발라드","323","1046");
			insertDB("못해", "포맨", "발라드","311","1046");
			insertDB("별이 될께", "디셈버", "발라드","320","1046");
			insertDB("화인", "김경호", "발라드","316","1109");
			insertDB("미련", "임창정", "발라드","312","1109");
			insertDB("슬픈 혼잣말", "임창정", "발라드","301","1109");
			insertDB("One Love", "MC the Max", "락","341","1109");
			insertDB("떠나가요 떠나지마요", "더크로스", "락","311","1109");

			insertDB("lately", "stevie wonde", "팝송","311","1109");
			insertDB("너를 사랑해", "김경호", "락","321","1175");
			insertDB("아름답게 사랑하는 날까지", "김경호", "락","331","1175");
			insertDB("Oasis", "김경호", "락","301","1175");
			insertDB("Epilogue", "김종서", "락","321","1175");
			insertDB("천년의 사랑", "박완규", "락","343","1175");
			insertDB("약속", "박완규", "락","300","1175");
			insertDB("내안에아직", "임창정", "발라드","323","1175");
			insertDB("너를 위해", "임재범", "락","343","1175");
			insertDB("베르사이유의 장미", "네미시스", "락","321","1175");
			insertDB("그것만이 내 세상", "이수", "발라드","325","1175");
			insertDB("슬픈바램", "부활", "락","330","1175");
			insertDB("친구야", "박완규", "락","310","1175");
			insertDB("love is over", "박완규", "락","331","1175");
			insertDB("언제나", "박완규", "락","315","1175");
			insertDB("비정", "김경호", "락","326","1245");
			insertDB("영원의 성", "김경호", "락","327","1245");
			insertDB("일기장", "KCM", "발라드","332","1245");
			insertDB("Smile again", "KCM", "발라드","330","1245");
			insertDB("바보같은 내게", "김범수", "발라드","338","1245");
			insertDB("형", "노라조", "락","349","1245");
			insertDB("사랑할수록", "박완규", "락","352","1245");
			insertDB("태양의 꿈", "박완규", "락","328","1245");
			insertDB("와인", "김경호", "락","351","1319");
			insertDB("금지된 사랑", "김경호", "락","344","1319");
			insertDB("Angel", "박완규", "락","332","1319");
			insertDB("스치듯 안녕", "이수영", "발라드","317","1319");
			insertDB("굿바이", "이수영", "발라드","328","1319");
			insertDB("그리고 사랑해", "이수영", "발라드","329","1319");
			insertDB("나 가거든", "조수미", "발라드","331","1319");
			insertDB("A tale that wasn't right", "Helloween", "팝송","319","1319");
			insertDB("Future world", "Helloween", "팝송","317","1319");
			insertDB("I want out", "Helloween", "팝송","346","1319");
			insertDB("18 & life", "Skid row", "팝송","325","1319");
			insertDB("The Way", "Stryper", "팝송","336","1319");
			insertDB("스치듯 안녕", "KCM", "발라드","347","1319");
			insertDB("Rain", "박완규", "락","329","1319");
			insertDB("닿을 수 없는 너", "박완규", "락","333","1319");
			insertDB("슬픈 영혼의 아리아", "김경호", "락","350","1397");
			insertDB("꿈에", "박정현", "발라드","319","1397");
			insertDB("몽중인", "박정현", "발라드","330","1397");
			insertDB("Don't cry", "더크로스", "락","350","1397");
			insertDB("I remember you", "Skid row", "팝송","321","1397");
			insertDB("나를 슬프게 하는 사람들", "김경호", "락","323","1397");
			insertDB("마지막 기도", "김경호", "락","310","1480");
			insertDB("Survival Game", "김경호", "락","330","1480");
			insertDB("Tatoo", "소찬휘", "락","329","1480");
			insertDB("흑백사진", "KCM", "발라드","351","1480");
			insertDB("She's gone", "Steel heart", "팝송","350","1568");
			insertDB("Rock And Roll", "Led Zepplin", "팝송","362","1568");
			insertDB("불멸의 사랑", "조성모", "발라드","339","1568");
			insertDB("Tears", "소찬휘", "락","348","1568");

		}
	}

	public void insertScale(String min, String max){
		if (dbHelper == null) {
			dbHelper = new DBHelper(MainActivity.this, "TEST", null, 1);
		}
		dbHelper.addScale(min,max);
	}

	public void insertDB(String n_music,String n_man,String n_ge,String v_min,String v_max){
		if (dbHelper == null) {
			dbHelper = new DBHelper(MainActivity.this, "TEST", null, 1);
		}
		Person person = new Person();
		person.setMusicName(n_music);
		person.setManName(n_man);
		person.setGeName(n_ge);
		person.setMin(v_min);
		person.setMax(v_max);
		dbHelper.addPerson(person);
	}


	ActionBar.TabListener listener= new ActionBar.TabListener() {
		@Override
		public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
			int position = tab.getPosition();
			switch( position ){
				case 0: //가장 왼쪽 Tab 선택(Analog)
					//MainActivity가 보여 줄 View를
					//res폴더>>layout폴더>>layout_tab_0.xml 로 설정
					setContentView(R.layout.activity_home);
					break;
				case 1:
					setContentView(R.layout.activity_search);
					break;
					/*
				case 2: //세번째 Tab 선택(Calendar)
					//MainActivity가 보여 줄 View를
					//res폴더>>layout폴더>>layout_tab_2.xml 로 설정
					setContentView(R.layout.activity_search);
					break;*/
			}
		}

		@Override
		public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		}
	};

	@Override
	public void onBackPressed(){
		moveTaskToBack(true);
		finish();
		android.os.Process.killProcess(android.os.Process.myPid());
	}

	private void setCustomActionbar() {
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayUseLogoEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);

		View mCustomView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
		actionBar.setCustomView(mCustomView);


		//actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.title));

		ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
		actionBar.setCustomView(mCustomView, params);
	}
}



