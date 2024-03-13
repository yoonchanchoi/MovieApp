# 구조

![13](https://github.com/yoonchanchoi/MovieApp/assets/74814647/0b8ac742-3db0-465f-831a-21ea7e25d9be)

MainAcitivity 
  - movieFragment
  - searchFragment
  - profilefragment

jetpack navigation을 통한 묶음
각각의 화면에서 movie 이미지 클릭시 DetailActivity로 넘어감
DetailActivity를 에서 이미지 similar 영화 클릭시 자기자신 Activity를 시작하고 Flag를 통해서 현재 엑티비가 다음 열리는 엑티비티와 같을 경우 현재 엑티비티를 재활용


## 각 화면별 간단 설명

MovieFragment는 Adapter를 통한 view 구성
SearchFragment 검색 api를 통한 데이터 호출 및 recyclerView의 스크롤 리스너를 통한 paging처리
DetailFragment는 이전 화면에 api를 가지고 Detail데이터 호출후 intent넘겨 받음


## 아쉽웠던 부분
hilt와 roomDb, Retrofit을 통해서 각각의 repository에 데이터를 받아오는 것을 분활 해보고 싶었음

jetpack navigation의 화면 이동 중 observe이 재호되는 경우가 있었음 이뉸 onViewCreated부터 
재시작이여서 재반응하는 것으로 봄 그래서 해당 로직을 flag로 해결하였지만 조금 더 좋은 방법 있을거 같아서 고민 중

동영상 처리 과정에서 너무 많은 시간을 소비함.


## 스크린샷


![13](https://github.com/yoonchanchoi/MovieApp/assets/74814647/cb075001-ecf4-42de-aba7-b20a0ebdaa6d)


