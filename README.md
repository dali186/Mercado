# Mercado
### 작업내역
##### Docker + docker-compose + GitHub Actions CD환경 구축 25.01.06(2days)
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
