# 구조


![1](https://github.com/yoonchanchoi/MovieApp/assets/74814647/a3f850b6-981b-49d2-8254-b3d05f352b1a)



## 화면 구조
- MainActivity 
    - MovieFragment
    - SearchFragment
    - ProfileFragment

- DetailMovieActivity
</br>

## 화면 이동
Jetpack Navigation을 통하여 Fragment간 화면 이동을 합니다.
MovieFragment, SearchFragment의 영화 Item을 클릭하게 되면 해당 영화의 상세 데이터 페이지(DetailMovieActivity)로 넘어가게 됩니다.
DetailMovieActivity에서 Similar 카테고리에 있는 영화 Item을 클릭하게 되면 Similar 영화 데이터가 담긴 DetailMovieActivity를 호출하게 됩니다. 이 과정에서 Task의 스택이 지속해서 쌓이는 것을 방지하기 위해 Flag를 이용했습니다.
</br>


## 화면 View 구성
MovieFragment는 여러 RecyclerView를 통해서 Item을 보여 줍니다.
SearchFragment는 검색 API로 받아온 결과값을 RecyclerView로 보여주며, addOnScrollListener를 통해 Paging 처리를 했습니다.
DetailMovieActivity는 Intent를 이용한 동영상 실행 기능과 영화의 상세 데이터를 보여 줍니다.
</br>


## 아쉬웠던 부분
Hilt와 RoomDB, Retrofit을 통해서 Repository에서 RoomDB 데이터와 Retrofit으로 받은 데이터를 나누어 보고 싶었습니다.
하지만 RoomDB를 제대로 구현하지 못하여 미완성했습니다.
</br>

Jetpack Navigation의 화면이동 중 observe가 재호출되는 경우가 있었는데 이 부분은 Fragment의 lifecycle이 destroy는 되지 않았지만 onViewCreated부터 
다시 실행되어 재반응하는 것으로 보였습니다. 그래서 해당 로직을 검사하는 Flag를 이용하여 해결했습니다. 하지만 조금 더 좋은 방법이 있을 것으로 보입니다.
</br>

마지막으로 동영상 기능에 너무 많은 시간을 사용했던 부분이 아쉬웠습니다.
</br>


## 스크린샷
![13](https://github.com/yoonchanchoi/MovieApp/assets/74814647/cb075001-ecf4-42de-aba7-b20a0ebdaa6d)


