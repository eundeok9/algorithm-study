def solution(id_pw, db):
    for user in db:
        if id_pw[0] in user:
            if id_pw[1] == user[1]:
                return "login"
            else:
                return "wrong pw"
    return "fail"