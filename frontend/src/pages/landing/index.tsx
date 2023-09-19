import React from "react";
import styled from "styled-components";
import LandingPage from "@/assets/img/LandingPage.jpg";
import LandingMainLogo from "@/assets/img/LandingMainLogo.png";
import FinanceLuckCards from "@/assets/img/FinanceLuckCards.png";
import CreditCards from "@/assets/img/CreditCards.png";
import Trophy from "@/assets/img/Trophy.png";
import Bottles from "@/assets/img/Bottles.png";

<link rel="stylesheet" type="text/css" href="@/styles.font.css" />;

const ToTarotContext = `귀여운 인간 손님이 왔네? 보아하니 고민이 있나본데...
아하, 알겠다! 요즘 소비가 늘어 걱정인 거구나? 뾰족한 수를 찾고 싶어? 🔮
간단한 해결책은 나오기 어렵지만...... 어쩌면 내가 도움이 될 지도 모르지.
앞으로 매주 나에게 방문하도록 하렴.
정말로 습관을 바꾸고 싶다면, 매주 타로를 보러 오는 것 정도는 괜찮지 않니?
내 타로점은 쉽게 볼 수 있는 게 아니란다.
네가 일주일 간 소비한 내용을 요정들에게 알아오라고 할게.
그 내용을 내가 확인한 후에 네 타로점을 봐줄 거야.
그림을 잘 그리는 요정도 있는데, 그 친구가 오직 너만을 위한 타로카드도 그려줄 거란다.
후후, 꽤나 기대되지 않니?`;

const RecommendContext = `아하, 인간 친구여! 네가 쓰는 돈의 이야기가 내 마법의 구슬을 통해 나타나네.🔮✨구슬에 나타난 소비패턴으로 특별한 카드를 찾아냈단다. 이 카드는 너의 지출에 따른 장점을 최대한 활용해, 너의 돈 주머니를 더욱 풍요롭게 만들어 줄 것이야.그리고 그 카드가 당신에게 가져다 줄 기적 같은 혜택들... 이미 요정들이 네게 보여주기 위해 그 혜택들을 준비 중이야. 🧚그리고 잊지마, 내가 추천하는 카드는 단순한 플라스틱 조각이 아니야. 그것은 너의 지출과 함께 네 인생의 여정에 빛나는 별이 될 수도 있단다. ✨후후, 마법의 세계에서 가장 완벽한 카드로 네 마음을 빛내 줄 준비가 되었니? 그렇다면, 지금 바로 그 빛을 찾아보도록 하자!" ‍🔮`;

const Chellange = `아, 다시 왔구나, 소중한 인간이여. 소비 챌린지에 대한 신비로운 이야기를 듣고 싶어?🔮 이 챌린지는 단순한 과제가 아니야. 이것은 당신의 지출 습관에 특별한 변화를 가져다 줄 마법의 챌린지란다. 소비 습관이 조금 허술해 보이는 것 같다면, 이 챌린지는 당신에게 희망의 빛을 선사할거야 별빛처럼 반짝이는 진정한 성취를 느낄 수 있을 테니까. 그리고 두려워 하지마. 요정들이 당신의 길을 밝혀줄 거란다. 후후, 별들이 반짝이는 밤하늘 아래, 우리의 소비 챌린지 여행을 함께 시작해볼까? ✨🌟`;

const FinanceLuck = `아하, 당신의 금전운을 엿보고 싶은 거구나? 🔮

주머니 속의 동전들이 너에게 무슨 이야기를 할까... 하늘에서 내려오는 별들의 빛처럼, 너의 재물의 흐름도 반짝거릴지도 모르지. 내 앞에 넓게 펼쳐진 타로카드들 중에서, 너의 미래의 재물을 가늠할 수 있는 카드를 골라줄게.

하지만, 이런 운명도 네가 스스로의 노력과 선택으로 만들어가는 것이란 것을 잊지 말아야 해. 타로는 가능성을 제시해주니까, 그것이 반드시 일어난다는 것을 보장하지 않는다는 점, 기억하렴.
그럼, 당신의 재물과 행운이 넘치길 바라며...🔮🌟`;

const Container = styled.div`
  background-image: url(${LandingPage});
  background-size: cover; /* 이미지를 화면 크기에 맞게 조절 */
  background-repeat: no-repeat; /* 이미지 반복 방지 */
  background-attachment: scroll; /* 배경 스크롤 허용 */
  background-position: center center; /* 이미지 중앙 정렬 */
  height: 700vh; /* 화면 높이만큼 설정 */
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const MainPage1 = styled.div`
  height: 110vh;
  width: 75%;
`;

const MainLogo = styled.img`
  height: 85vh;
  width: 100%;
`;

const MainComment = styled.div`
  color: #fae7a9;
  text-shadow: 1px 1px 10px rgba(255, 255, 255, 0.7);
  font-family: "PyeongChangPeace";
  font-size: 32px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  letter-spacing: 3.2px;
`;

const MainPages = styled.div`
  height: 110vh;
  width: 75%;
  display: flex;
  justify-content: center;
  flex-direction: column;
`;

const Content = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 70%;
`;
const Witch = styled.div`
  margin-bottom: 40px;
  height: 7vh;
  width: 142px;
  border-radius: 19px;
  background: rgba(77, 27, 69, 0.5);
  box-shadow:
    0px 5px 10px 0px rgba(255, 255, 255, 0.1) inset,
    5px 0px 10px 0px rgba(255, 255, 255, 0.1) inset,
    0px -5px 10px 0px rgba(255, 255, 255, 0.1) inset,
    -5px 0px 10px 0px rgba(255, 255, 255, 0.1) inset;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #fff;
  font-family: "Pretendard";
  font-size: 20px;
  font-style: normal;
  font-weight: 700;
  line-height: 32px; /* 106.667% */
`;

const Context = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 19px;
  background: rgba(77, 27, 69, 0.5);
  box-shadow:
    0px 5px 10px 0px rgba(255, 255, 255, 0.1) inset,
    5px 0px 10px 0px rgba(255, 255, 255, 0.1) inset,
    0px -5px 10px 0px rgba(255, 255, 255, 0.1) inset,
    -5px 0px 10px 0px rgba(255, 255, 255, 0.1) inset;
  height: 50vh;
  width: 90.25%;
  color: #fff;
  font-family: "Pretendard";
  font-size: 19px;
  font-style: normal;
  font-weight: 500;
  line-height: 32px; /* 152.381% */
  padding: 30px;
`;

const Titles = styled.div`
  margin-bottom: 20px;
  color: #fff;
  font-family: "PyeongChangPeace";
  font-size: 45px;
  text-align: left;
  width: 100%;
  display: flex;
  align-items: center;
`;

const Page24Left = styled.div`
  height: 100%;
  width: 60%;
  display: flex;
  justify-content: center;
  flex-direction: column;
`;

const Page35Right = styled.div`
  height: 100%;
  width: 50%;
`;

const Page2Right = styled.div`
  height: 100%;
  width: 40%;
  background-image: url(${FinanceLuckCards});
  background-position: center;
  background-repeat: no-repeat;
  background-size: contain;
`;

const Page3Left = styled.div`
  height: 80%;
  width: 50%;
  display: flex;
  justify-content: center;
  flex-direction: column;
  background-image: url(${CreditCards});
  background-position: center;
  background-repeat: no-repeat;
  background-size: contain;
`;

const Page4Right = styled.div`
  height: 100%;
  width: 50%;
  background-image: url(${Trophy});
  background-position: center;
  background-repeat: no-repeat;
  background-size: contain;
`;

const Page5Left = styled.div`
  height: 80%;
  width: 50%;
  display: flex;
  justify-content: center;
  flex-direction: column;
  background-image: url(${Bottles});
  background-position: center;
  background-repeat: no-repeat;
  background-size: contain;
`;

const Landing: React.FC = () => {
  return (
    <Container>
      <MainPage1>
        <MainLogo src={LandingMainLogo} />
        <MainComment>•──☾ 소비패턴 분석을 통한 타로카드 생성 ☽──•</MainComment>
      </MainPage1>
      <MainPages>
        <Content>
          <Page24Left>
            <Titles>
              <p>나의 소비 패턴을 타로카드로</p>
            </Titles>
            <Witch>🌟 마녀 🌟</Witch>
            <Context>{ToTarotContext}</Context>
          </Page24Left>
          <Page2Right></Page2Right>
        </Content>
      </MainPages>
      <MainPages>
        <Content>
          <Page3Left />
          <Page35Right>
            <Titles>
              <p>마녀가 추천해주는 나의 카드</p>
            </Titles>
            <Witch>🌟 마녀 🌟</Witch>
            <Context>{RecommendContext}</Context>
          </Page35Right>
        </Content>
      </MainPages>
      <MainPages>
        <Content>
          <Page24Left>
            <Titles>
              <p>챌린지를 통해 소비습관을 교정</p>
            </Titles>
            <Witch>🌟 마녀 🌟</Witch>
            <Context>{Chellange}</Context>
          </Page24Left>
          <Page4Right></Page4Right>
        </Content>
      </MainPages>
      <MainPages>
        <Content>
          <Page5Left></Page5Left>
          <Page35Right>
            <Titles>
              <p>나의 금전운에 대해 알아보자</p>
            </Titles>
            <Witch>🌟 마녀 🌟</Witch>
            <Context>{FinanceLuck}</Context>
          </Page35Right>
        </Content>
      </MainPages>
      <MainPages>
        <Content>
          <div>🌟 어디로 갈 지 골라보겠니? 🌟</div>
          <div></div>
        </Content>
      </MainPages>
    </Container>
  );
};

export default Landing;