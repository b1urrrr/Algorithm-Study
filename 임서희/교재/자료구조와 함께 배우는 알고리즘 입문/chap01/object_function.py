# 함수 내부/외부에서 정의한 변수와 객체의 식별 번호 출력하기

n = 1 # 전역 변수

def put_id():
    x = 1 # 지역 변수
    print(f'id(x) = {id(x)}')
    
print(f'id(1) = {id(1)}')
print(f'id(n) = {id(n)}')
put_id()

# int형 객체 1을 참조하는 이름에 불과하여 1, n, x의 식별 번호가 모두 같다.