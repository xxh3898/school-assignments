
# GitHub에서 하위 레포 통합하며 발생한 서브모듈 문제 해결 경험

## 🧩 문제 상황
- 기존에 여러 과제별 GitHub 레포지토리를 만들었고, 이를 하나의 통합 레포 (`school-assignments`)에 모으려 했음.
- 각 과제 폴더 내부에도 `.git` 폴더가 존재하여, Git은 이들을 **서브모듈(submodule)**로 인식함.
- 결과적으로 `git add .` 시 실제 파일이 아닌, **서브모듈 참조만 커밋**되어 GitHub에 아무것도 보이지 않음.

## 🔍 원인 분석
- 상위 디렉토리에서 Git 저장소를 초기화하고 하위 폴더를 복사할 때, 하위 폴더의 `.git` 폴더까지 같이 복사됨.
- Git은 각 폴더를 별도의 저장소(서브모듈)로 인식하게 되고, 내용이 아니라 참조만 기록됨.

## ✅ 해결 방법

### 1. 상위 폴더에서 Git 저장소 초기화
```bash
git init
git remote add origin https://github.com/xxh3898/school-assignments.git
git branch -M main
```

### 2. 하위 폴더의 `.git` 폴더 삭제
```bash
# school-assignments 디렉토리 내에서 실행
find . -type d -name ".git" -exec rm -rf {} +
```
> 또는 각 폴더 안으로 들어가서 수동으로 `.git` 폴더 삭제 가능

### 3. 전체 파일 커밋 후 푸시
```bash
git add .
git commit -m "fix: 서브모듈 제거 후 파일 통합"
git push -f origin main
```

## 💡 배운 점
- 하위 폴더에 `.git`이 있으면 Git은 이를 서브모듈로 인식함
- 레포를 통합할 땐 하위 `.git` 제거 후 관리하는 게 중요함
- 실수도 경험이 되고, 이 과정을 통해 Git의 동작 원리를 더 깊게 이해할 수 있었음

## 📌 느낀 점
> 단순한 파일 복사가 아니라, Git 구조와 개념을 이해해야 문제를 해결할 수 있음을 느꼈다.  
> 이런 문제를 직접 겪고 해결한 경험은 실무에서도 큰 도움이 될 것 같다.
