import React, { useState } from 'react';
import {
    Avatar,
    Button,
    CssBaseline,
    TextField,
    FormControl,
    FormControlLabel,
    Checkbox,
    Grid,
    Box,
    Typography,
    Container,
} from '@mui/material/';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import './Singup.css';
import axios from "axios";

const Signup = () => {
    const theme = createTheme();
    const [checked, setChecked] = useState(false);

    // 동의 체크
    const handleAgree = (event) => {
        setChecked(event.target.checked);
    };

    // form 전송
    const handleSubmit = (e) => {
        e.preventDefault();
    };


    const [id, setId] = useState('');
    const [password, setPassword] = useState('');
    const [confirm, setConfirm] = useState('');

    const [idError, setIdError] = useState('');
    const [passwordError, setPasswordError] = useState('');
    const [confirmError, setConfirmError] = useState('');

    const [isIdCheck, setIsIdCheck] = useState(false); // 중복 검사를 했는지 안했는지
    const [isIdAvailable, setIsIdAvailable] = useState(false); // 아이디 사용 가능한지 아닌지


    const onChangeIdHandler = (e) => {
        console.log(e.target.value);
        const idValue = e.target.value;
        setId(idValue);
        idCheckHandler(idValue);
    }

    const idCheckHandler = async (id) => {
        const idRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (id === '') {
            setIdError('아이디를 입력해주세요.');
            setIsIdAvailable(false);
            return false;
        } else if (!idRegex.test(id)) {
            setIdError('아이디는 5~10자의 영소문자, 숫자만 입력 가능합니다.');
            setIsIdAvailable(false);
            return false;
        }
        try {
            const responseData = await axios
                .post("http://localhost:8080/member/duplicate",{
            }).then((res) => {
                console.log(res);
            })

            // if (responseData) {
            //     setIdError('사용 가능한 아이디입니다.');
            //     setIsIdCheck(true);
            //     setIsIdAvailable(true);
            //     return true;
            // } else {
            //     setIdError('이미 사용중인 아이디입니다.');
            //     setIsIdAvailable(false);
            //     return false;
            // }
        } catch (error) {
            alert('서버 오류입니다. 관리자에게 문의하세요.');
            console.error(error);
            return false;
        }
    }

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <CssBaseline />
                <Box
                    sx={{
                        marginTop: 8,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}
                >
                    <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }} />
                    <Typography component="h1" variant="h5">
                        회원가입
                    </Typography>
                    <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
                        <FormControl component="fieldset" variant="standard">
                            <Grid container spacing={2}>
                                <Grid item xs={12}>
                                    <TextField
                                        required
                                        autoFocus
                                        fullWidth
                                        type="email"
                                        id="email"
                                        name="email"
                                        label="이메일 주소"
                                        onChange={onChangeIdHandler}
                                    />
                                </Grid>
                                {idError && <small style={{marginLeft:'17px', marginTop:'5px'}} className={isIdAvailable ? '' : 'idAvailable'}>{idError}</small>}
                                <Grid item xs={12}>
                                    <TextField
                                        required
                                        fullWidth
                                        type="password"
                                        id="password"
                                        name="password"
                                        label="비밀번호 (숫자+영문자+특수문자 8자리 이상)"
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField
                                        required
                                        fullWidth
                                        type="password"
                                        id="rePassword"
                                        name="rePassword"
                                        label="비밀번호 재입력"
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField required fullWidth id="name" name="name" label="이름" />
                                </Grid>
                                <Grid item xs={12}>
                                    <FormControlLabel
                                        control={<Checkbox onChange={handleAgree} color="primary" />}
                                        label="회원가입 약관에 동의합니다."
                                    />
                                </Grid>
                            </Grid>
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                sx={{ mt: 3, mb: 2 }}
                                size="large"
                            >
                                회원가입
                            </Button>
                        </FormControl>
                    </Box>
                </Box>
            </Container>
        </ThemeProvider>
    );
};
export default Signup;