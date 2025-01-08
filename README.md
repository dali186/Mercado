# Mercado
### 작업내역
25.01.06(2days)
##### Docker + docker-compose + GitHub Actions CD환경 구축
![docker_compose_actions](https://github.com/user-attachments/assets/121bd1ad-c0b4-49fa-8db9-afba533ff175)
##### 이슈내용
1. GitHub Actions runner에서의 docker-compose.yml 파일 참조 이슈
- AS-IS: GitHub Actions Runner에서 docker-compose.yml 파일을 참조하지 못함.
  - 로그를 통해 경로 및 docker-compose.yml 파일 존재 여부를 확인.
  - 하지만 Runner Host 내부에서 경로가 제대로 매핑되지 않음.
    - `FileNotFoundError: [Errno 2] No such file or directory: 'docker-compose.yml'`
- TO-BE : GitHub Actions runner host에서 진행하지 않고, DockerHub에 push/pull 방식으로 변경
  - 컨테이너 이미지를 GitHub Actions Runner Host에서 직접 빌드하지 않음.
  - 대신 DockerHub를 활용하여 Push/Pull 방식으로 프로세스 변경.
- 특이사항
  - docker-compose.yml 파일은 프로젝트 최상단에 위치, /home/Mercado/compose/docker-compose.yml 경로로 이동 후 빌드
    
25.01.07(1days)
##### 공통 응답 세팅 및 기본 Entity CRUD 구현
##### 이슈내용
1. JPA
- Hibernate는 엔티티 클래스를 생성할 때 기본 생성자를 사용하기 때문에 Entity에 필수로 구현해둘 것
2. JUnit
- Mockito를 이용한 단위테스트 구현

25.01.08(1days)
##### STOMP chat, 프로토타입 구현
##### 이슈내용
1. 고도화
  - 화면 구현 후 고도화 진행
  - 추후 외부 메세지 큐 구현 
