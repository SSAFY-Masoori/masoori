import styled from "styled-components";

export interface StyledTarotCardProps {
  width: string;
  height: string;
  cardWidth: string;
  cardSrc: string;
  imageSrc: string;
  bottomImageWidth: string;
  text: string;
  fontsize: string;
}

const StyledTarotCardContainer = styled.div<{ width: string; height: string }>`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  position: relative;
`;

const StyledTarotCardTop = styled.div<{ cardWidth: string }>`
  width: ${(props) => props.cardWidth};
  height: auto;
  position: absolute;
  z-index: 1;
`;

const TopImage = styled.img<{ cardWidth: string }>`
  width: ${(props) => props.cardWidth};
  height: auto;
`;

const StyledTarotCardBottom = styled.div<{ cardWidth: string }>`
  width: 97.5%;
  position: relative;
  z-index: 0;
  margin: 0 auto;
  height: 100%;
  overflow: hidden;
`;

const BottomImage = styled.img<{ bottomImageWidth: string }>`
  width: ${(props) => props.bottomImageWidth};
  height: auto;
`;

const BottomText = styled.div<{ text: string; fontsize: string }>`
  position: relative;
  z-index: 1;
  font-size: ${(props) => props.fontsize};
  color: #5e3a66;
  font-family: "Museum";
`;

const TarotCard = ({
  width,
  height,
  cardWidth,
  cardSrc,
  imageSrc,
  bottomImageWidth,
  text,
  fontsize,
}: StyledTarotCardProps) => {
  return (
    <StyledTarotCardContainer width={width} height={height}>
      <StyledTarotCardTop cardWidth={cardWidth}>
        <TopImage cardWidth={cardWidth} src={cardSrc}></TopImage>
      </StyledTarotCardTop>
      <StyledTarotCardBottom cardWidth={cardWidth}>
        <BottomImage
          bottomImageWidth={bottomImageWidth}
          src={imageSrc}
        ></BottomImage>
      </StyledTarotCardBottom>
      <BottomText text={text} fontsize={fontsize}>
        {text}
      </BottomText>
    </StyledTarotCardContainer>
  );
};

export default TarotCard;